package com.aros.myapplication;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aros.arossdk.api.AMSSDKManager;
import com.aros.arossdk.api.Config;
import com.aros.arossdk.api.FlightState;
import com.aros.arossdk.callback.MqttListener;
import com.aros.arossdk.callback.ServerControlListener;


import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends Activity implements EasyPermissions.PermissionCallbacks {

    private String TAG=getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        initView();
        //2.监听
        addLisener();
        //1.初始化
        init();

    }

    EditText etAddr, etUserName, etPassword, etSn;
    Button btnDockOpen, btnDockClose, btnDockIn, btnDockShut, btnPushFlightState,btnConnect;

    private void initView() {
        etAddr = findViewById(R.id.et_mqtt_server_uri);
        etUserName = findViewById(R.id.et_mqtt_username);
        etPassword = findViewById(R.id.et_mqtt_password);
        etSn = findViewById(R.id.et_mqtt_sn);
        btnDockOpen = findViewById(R.id.btn_dock_open);
        btnDockClose = findViewById(R.id.btn_dock_close);
        btnDockIn = findViewById(R.id.btn_dock_in);
        btnDockShut = findViewById(R.id.btn_dock_shut);
        btnPushFlightState = findViewById(R.id.btn_push_flight_state);
        btnConnect = findViewById(R.id.btn_connect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3.连接
                AMSSDKManager.getInstance().connect();
            }
        });
        btnDockOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AMSSDKManager.getInstance().sendDockOpenCommand();
            }
        });
        btnDockClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AMSSDKManager.getInstance().sendDockCloseCommand();
            }
        });
        btnDockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AMSSDKManager.getInstance().sendDockStockInCommand();
            }
        });
        btnDockShut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AMSSDKManager.getInstance().sendDockShutDownCommand();
            }
        });
        btnPushFlightState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlightState state=new FlightState();
                //返航点经纬度
                state.setHomepointLat("xxx");
                state.setHomepointLong("xxx");
                //返航距离
                state.setDistance(100);
                //海拔高度
                state.setEgm96Altitude(50);
                //水平速度
                state.setHorizontalSpeed(5+"");
                //垂直速度
                state.setVerticalSpeed(5+"");
                //风速（分米）
                state.setWindSpeed(50);
                //卫星数
                state.setSatelliteNumber(1);
                //GPS信号等级（字符串）
                state.setGPSSignalLevel("LEVEL_0");
                //遥控器信号
                state.setRemoteControlSignal(50);
                //图传信号
                state.setPictureBiographySignal(100);
                //电池A剩余电量
                state.setElectricityInfoA(50);
                //电池A电压 (mV)
                state.setVoltageInfoA(15578);
                //电池A温度
                state.setBatteryTemperatureA(50);
                state.setElectricityInfoB(50);
                state.setVoltageInfoB(14444);
                state.setBatteryTemperatureB(50);
                //飞机状态信息，对应DJIDeviceStatus
                state.setPlaneMessage("NORMAL_RTK");
                //飞机警告信息，对应DJIDeviceHealthInfoChangeListener
                state.setWarningMessage("");
                //机头朝向 对应KeyCompassHeading
                state.setAngleYaw(0);
                //航线名称 onMissionFileReceive航线下发时连带过来的
                state.setFlightPathName("test");
                //航线id onMissionFileReceive航线下发时连带过来的
                state.setFlightId("flightId");
                //航线执行状态字符串 对应addWaypointMissionExecuteStateListener
                state.setWaypointMissionExecuteState("EXECUTING");
                //是否正在执行航线任务
                state.setAirlineFlight(true);
                //航线状态（0 航线飞行中 1 航线暂停中 2航线已终止）
                state.setFlightPathStatus(0);
                //返航执行状态（0返航未执行 1正在返航 2正在降落 3返航执行完成）
                state.setGoHomeState(1);
                //时间
                state.setTimestamp(System.currentTimeMillis());
                //当前飞机在第几个航点
                state.setCurrentWaypointIndex(0);
                //当前飞机经纬度
                state.setCurrentLongitude("xxx");
                state.setCurrentLatitude("xxx");
                //相对高度
                state.setFlyingHeight(50);
                //飞机姿态
                state.setRoll("20");
                state.setPitch("35");
                state.setYaw("36");
                //云台姿态
                state.setGimbalRoll("20.0");
                state.setGimbalPitch("30.0");
                state.setGimbalYaw("30.0");
                AMSSDKManager.getInstance().subFlightState(state);
            }
        });
    }

    private void init() {
        Config config = new Config();
        config.setServerUri(etAddr.getText().toString().trim());
        config.setUserName(etUserName.getText().toString().trim());
        config.setPassword(etPassword.getText().toString().trim());

        config.setSn(etSn.getText().toString().trim());
        AMSSDKManager.getInstance().init(this, config);
    }

    private void addLisener() {
        AMSSDKManager.getInstance().setControlListener(new ServerControlListener() {
            @Override
            public boolean onQueryAircraftConnectStatus() {
                return false;
            }

            @Override
            public void onDockActionReceive(String s) {

            }

            @Override
            public void onMissionFileReceive(int type, String flightId, String flightName, String missionFileUrl) {

            }

            @Override
            public void onMissionPause(int type) {

            }

            @Override
            public void onMissionResume(int type) {

            }

            @Override
            public void onStartGoHome(int type) {

            }

            @Override
            public void onCancelGoHome(int type) {

            }

            @Override
            public void onMissionStop(int type) {

            }

            @Override
            public void onEmergencyLanding(int type) {

            }
        });
        AMSSDKManager.getInstance().setMqttListener(new MqttListener() {
            @Override
            public void onConnectSuccess() {
                Log.e(TAG,"connect success");
                Toast.makeText(MainActivity.this,"mqtt connect success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onConnectonFailure(String s) {
                Log.e(TAG,"connect fail:"+s);
                Toast.makeText(MainActivity.this,"connect fail",Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onResponseException(int i, String s) {

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Some permissions have been granted
        // ...
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Some permissions have been denied
        // ...

    }
}
