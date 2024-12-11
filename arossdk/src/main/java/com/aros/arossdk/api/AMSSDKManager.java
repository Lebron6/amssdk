package com.aros.arossdk.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.aros.arossdk.callback.MqttListener;
import com.aros.arossdk.callback.ServerControlListener;
import com.aros.arossdk.entity.Message;
import com.aros.arossdk.entity.MessageReply;
import com.aros.arossdk.tools.Utils;
import com.google.gson.Gson;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class AMSSDKManager {

    private static final String MQTT_TOPIC_UAV_STATUS = "nest/%s/uav_status_message";
    private static final String MQTT_TOPIC_UAV_SERVICES_REPLY = "nest/%s/uav_services_reply";
    private static final int MQTT_QOS = 0;
    private String TAG = getClass().getSimpleName();
    private MqttAndroidClient mMqttClient;
    private MqttConnectOptions mMqttOptions;
    private String sn;

    private AMSSDKManager() {
    }

    private static class AMSSDKManagerHolder {
        private static final AMSSDKManager INSTANCE = new AMSSDKManager();
    }

    public static AMSSDKManager getInstance() {
        return AMSSDKManagerHolder.INSTANCE;
    }

    public void init(Context context, Config config) {
        if (mMqttClient != null && mMqttClient.isConnected()) {
            Log.e(TAG, "mqtt 已连接");
            return;
        }
        if (mMqttOptions == null) {
            mMqttOptions = new MqttConnectOptions();
        }
        sn = config.getSn();
        mMqttOptions.setAutomaticReconnect(true); //ltz add
        mMqttOptions.setMaxInflight(100);// 增加最大并发未确认消息数量
        mMqttOptions.setCleanSession(false); //设置是否清除缓存
        mMqttOptions.setConnectionTimeout(30); //设置超时时间，单位：秒 ltz denote
        mMqttOptions.setKeepAliveInterval(5); //设置心跳包发送间隔，单位：秒 ltz denote
        mMqttOptions.setUserName(config.getUserName()); //设置用户名
        mMqttOptions.setPassword(config.getPassword().toCharArray()); //设置密码
        mMqttClient = new MqttAndroidClient(context, config.getServerUri(),
                Utils.generateRandomString(10));

    }


    public void connect() {
        if (mMqttClient != null && mMqttClient.isConnected()) {
            Log.e(TAG, "mqtt 已连接");
            return;
        }
        Log.e(TAG, new Gson().toJson(mMqttOptions));
        try {
            mMqttClient.connect(mMqttOptions, iMqttActionListener);
        } catch (MqttException e) {
            Log.e(TAG, "连接异常:" + e.toString());
            throw new RuntimeException(e);
        }
        mMqttClient.setCallback(mqttCallback); //设置监听订阅消息的回调
    }

    public void reConnect() {
        if (null != mMqttClient) {
            try {
                mMqttClient.connect(mMqttOptions);
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        }
    }

    MqttCallbackExtended mqttCallback = new MqttCallbackExtended() {
        @Override
        public void connectComplete(boolean reconnect, String serverURI) {
            try {
                if (reconnect) {//重新订阅
                    mMqttClient.subscribe("nest/" + sn + "/uav_services", 0);//订阅主题:注册
                }
            } catch (Exception e) {
                Log.e(TAG, "订阅异常:" + e.toString());

            }
        }

        @Override
        public void connectionLost(Throwable cause) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    reConnect();
                }
            }, 2000);
        }

        @Override
        public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
            String json = null;
            try {
                json = new String(mqttMessage.getPayload(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, "解析异常:" + e.toString());
                throw new RuntimeException(e);
            }
            Message message = new Gson().fromJson(json, Message.class);
            switch (message.getMsg_type()) {
                //遥控器是否开机
                case 60001:
                    response2Server(message.getMsg_type());
                    break;
                //飞机是否连接
                case 60002:
                    boolean isConnect = controlListener.onQueryAircraftConnectStatus();
                    if (isConnect) {
                        response2Server(message.getMsg_type());
                    }
                    break;
                //航线文件下发
                case 60003:
                    if (!TextUtils.isEmpty(message.getUpload_url())){
                        Log.e(TAG, "minio媒体文件上传地址为空");
                        return;
                    }
                    String[] splitUrl = message.getUpload_url().split("//")[1].split("/");
                    if (!(splitUrl.length<4)){
                        controlListener.onMissionFileReceive(message.getMsg_type(), message.getFlightId(),message.getFlight_name(),
                                "http://" + splitUrl[0],splitUrl[1],splitUrl[2],splitUrl[3],message.getAccess_key(),
                                 message.getKmz_url());
                    }else{
                        Log.e(TAG, "minio媒体文件上传地址格式有误:"+message.getUpload_url());
                    }
                    break;
                //航线暂停
                case 60004:
                    controlListener.onMissionPause(message.getMsg_type());
                    break;
                //航线继续
                case 60005:
                    controlListener.onMissionResume(message.getMsg_type());
                    break;
                //返航
                case 60006:
                    controlListener.onStartGoHome(message.getMsg_type());
                    break;
                //获取虚拟摇杆控制权
                case 60007:
                    controlListener.onVirtualStickModeEnabled(message.getMsg_type(),true);
                    break;
                //接收虚拟摇杆杆量数据
                case 60008:
                    controlListener.onVirtualStickAdvancedParamReceive(message.getMsg_type(),
                            Double.valueOf(message.getX()), Double.valueOf(message.getY()),
                            Double.valueOf(message.getR()), Double.valueOf(message.getZ()));
                    break;
                //云台角度控制
                case 60009:
                    controlListener.onGimbalRotateByRelativeAngle(message.getMsg_type(),
                            Double.valueOf(message.getX()), Double.valueOf(message.getY()));
                    break;
                //取消虚拟摇杆控制权
                case 60016:
                    controlListener.onVirtualStickModeEnabled(message.getMsg_type(),false);
                    break;
                //切换视频源 1广角 2变焦 3红外
                case 60017:
                    controlListener.onSwitchCameraVideoStreamSource(message.getMsg_type(),message.getCameraVideoStreamSource());
                    break;
                //设置相机模式 0拍照 1录像
                case 60018:
                   controlListener.onSwitchCameraMode(message.getMsg_type(),message.getCameraMode());
                    break;
                //取消返航
                case 60106:
                    controlListener.onCancelGoHome(message.getMsg_type());
                    break;
                //航线终止
                case 60109:
                    controlListener.onMissionStop(message.getMsg_type());
                    break;
                //紧急降落点降落
                case 60112:
                    controlListener.onEmergencyLanding(message.getMsg_type());
                    break;
                //服务端响应地面站客户端对机库的操作请求
                case 60999:
                    controlListener.onDockActionReceive(message.getStatus());
                    break;
            }
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {

        }
    };

    IMqttActionListener iMqttActionListener = new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            try {
                mMqttClient.subscribe("nest/" + sn + "/uav_services", 0);//订阅主题:注册
            } catch (MqttException e) {
                e.printStackTrace();
            }
            mqttListener.onConnectSuccess();
        }

        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            mqttListener.onConnectonFailure(exception.toString());
        }
    };

    public void setMqttListener(MqttListener mqttListener) {
        this.mqttListener = mqttListener;
    }

    public void setControlListener(ServerControlListener controlListener) {
        this.controlListener = controlListener;
    }

    private ServerControlListener controlListener;
    private MqttListener mqttListener;


    public void subFlightState(FlightState state) {
        MqttMessage flightMessage = createMqttMessage(state);
        if (flightMessage != null) {
            publishMessage(flightMessage, String.format(MQTT_TOPIC_UAV_STATUS, sn), state.getMsg_type());
        }
    }

    private void sendReplyToServer(int type, String msg, boolean isErrorMessage) {
        MessageReply messageReply = new MessageReply();
        messageReply.setMsg_type(type);
        if (isErrorMessage) {
            messageReply.setResult(-1);
            messageReply.setMsg(msg);
        } else {
            messageReply.setResult(1);
        }
        MqttMessage mqttMessage = createMqttMessage(messageReply);
        publishMessage(mqttMessage, String.format(MQTT_TOPIC_UAV_SERVICES_REPLY, sn), type);
    }


    private MqttMessage createMqttMessage(Object payload) {
        try {
            return new MqttMessage(new Gson().toJson(payload).getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void publishMessage(MqttMessage message, String topic, int msgType) {
        try {
            if (mMqttClient.isConnected()) {
                message.setQos(MQTT_QOS);
                mMqttClient.publish(topic, message, null, new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        handlePublishFailure(msgType, exception);
                    }
                });
            } else {
                handlePublishFailure(msgType, new Exception("mqtt 未连接"));
            }
        } catch (Exception e) {
            handlePublishFailure(msgType, e);
        }
    }

    private void handlePublishFailure(int msgType, Throwable exception) {
        mqttListener.onResponseException(msgType, exception.toString());
        exception.printStackTrace();
    }

    public void response2Server(int type) {
        sendReplyToServer(type, null, false);
    }

    public void responseErrorMsg2Server(int type, String msg) {
        sendReplyToServer(type, msg, true);
    }

    //飞机飞回，发送打开机库门
    public void sendDockOpenCommand() {
        sendReplyToServer(60108, null, false);
    }

    //飞机飞走，发送关闭机库门
    public void sendDockCloseCommand() {
        sendReplyToServer(60107, null, false);
    }

    //飞机降落，入库
    public void sendDockStockInCommand() {
        sendReplyToServer(60010, null, false);
    }

    //文件上传完毕，关机()
    public void sendDockShutDownCommand() {
        sendReplyToServer(60011, null, false);
    }
}
