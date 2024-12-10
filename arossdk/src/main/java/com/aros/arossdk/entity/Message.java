package com.aros.arossdk.entity;

public class Message {

    private int result;
    private String kmz_url;
    private String rtmp_push_url;
    private String upload_url;
    private String access_key;
    private String secret_key;
    private String region;
    private String flight_name;
    private int streamIndex=0;//0 云台视角 1FPV
    private int liveStreamQuality;//设置推流分辨率 1标清 2高清 3超清
    private int cameraVideoStreamSource;//相机视频流 1广角 2变焦 3红外
    private int cameraMode;//设置相机拍照录像模式 0拍照  1录像
    private int cameraZoomRatios;//设置变焦镜头倍率 (isContinuousH20T为true,关键倍率[2,5,10,20,40,80,160,200])
    private int thermalZoomRatios;//设置红外镜头倍率 (1x 2x 4x 8x)
    private int heightLimit;//限高
    private int distanceLimitEnabled;//限远是否启用 1启用 0不启用
    private int distanceLimit;//限远
    private String flightId;//航线id
    private int isGuidingFlight;//是否是指点飞行 0否 1是

    private int x=0;//前后
    private int y=0;//左右
    private int z=0;//上下
    private int r=0;//自旋
    private int megaphoneVolume;//喊话器音量
    private int megaphonePlayMode;//喊话器播放模式
    private String megaphoneWord;//喊话器文字内容
    private int cameraExposureMode;//曝光模式
    private int cameraExposureCompensation;//曝光补偿数值
    private int AELockEnabled;//曝光锁定
    private double shootInterval;//拍照间隔时间
    private int shootCount;//拍照的张数
    private int msg_type;
    private String alternatePointLat;//设置备降点经纬度
    private String alternatePointLon;
    private String offSitePointLat;//设置异地降落经纬度
    private String offSitePointLon;
    private String alternatePointSecurityHeight; //备降点安全起飞高度
    private String alternatePointHeight; //备降点高度
    private String alternatePointTimes; //允许复降次数
    private double zoomTargetX; //坐标x,范围0-1
    private double zoomTargetY; //坐标y,范围0-1
    private int cameraFocusMode; //对焦模式
    private String xmpInfo;//写入exif信息
    private String payloadData;//发送数据给psdk
    private int cameraFocusRingValue;//设置相机对焦值
    private String status;//收到机库状态的回执消息
    private String flag;//后端用来区别里程(用作AI)
    private int isCleanMode;//是否清洁模式
    private int thermalTemperatureMeasureMode;//红外测温模式
    private String metersurePointX;//点测温位置
    private String metersurePointY;
    private String metersureAreaX;//区域测温矩形左上角起始位置
    private String metersureAreaY;
    private String metersureAreaWidth;//测温矩形长度
    private String metersureAreaHeight;//测温矩形宽度

    public String getMetersurePointX() {
        return metersurePointX;
    }

    public void setMetersurePointX(String metersurePointX) {
        this.metersurePointX = metersurePointX;
    }

    public String getMetersurePointY() {
        return metersurePointY;
    }

    public void setMetersurePointY(String metersurePointY) {
        this.metersurePointY = metersurePointY;
    }

    public String getMetersureAreaX() {
        return metersureAreaX;
    }

    public void setMetersureAreaX(String metersureAreaX) {
        this.metersureAreaX = metersureAreaX;
    }

    public String getMetersureAreaY() {
        return metersureAreaY;
    }

    public void setMetersureAreaY(String metersureAreaY) {
        this.metersureAreaY = metersureAreaY;
    }

    public String getMetersureAreaWidth() {
        return metersureAreaWidth;
    }

    public void setMetersureAreaWidth(String metersureAreaWidth) {
        this.metersureAreaWidth = metersureAreaWidth;
    }

    public String getMetersureAreaHeight() {
        return metersureAreaHeight;
    }

    public void setMetersureAreaHeight(String metersureAreaHeight) {
        this.metersureAreaHeight = metersureAreaHeight;
    }

    public int getThermalTemperatureMeasureMode() {
        return thermalTemperatureMeasureMode;
    }

    public void setThermalTemperatureMeasureMode(int thermalTemperatureMeasureMode) {
        this.thermalTemperatureMeasureMode = thermalTemperatureMeasureMode;
    }

    public int getIsCleanMode() {
        return isCleanMode;
    }

    public void setIsCleanMode(int isCleanMode) {
        this.isCleanMode = isCleanMode;
    }

    public String getOffSitePointLat() {
        return offSitePointLat;
    }

    public void setOffSitePointLat(String offSitePointLat) {
        this.offSitePointLat = offSitePointLat;
    }

    public String getOffSitePointLon() {
        return offSitePointLon;
    }

    public void setOffSitePointLon(String offSitePointLon) {
        this.offSitePointLon = offSitePointLon;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getXmpInfo() {
        return xmpInfo;
    }

    public void setXmpInfo(String xmpInfo) {
        this.xmpInfo = xmpInfo;
    }

    public String getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(String payloadData) {
        this.payloadData = payloadData;
    }

    public int getCameraFocusRingValue() {
        return cameraFocusRingValue;
    }

    public void setCameraFocusRingValue(int cameraFocusRingValue) {
        this.cameraFocusRingValue = cameraFocusRingValue;
    }

    public int getCameraFocusMode() {
        return cameraFocusMode;
    }

    public void setCameraFocusMode(int cameraFocusMode) {
        this.cameraFocusMode = cameraFocusMode;
    }

    public double getZoomTargetX() {
        return zoomTargetX;
    }

    public void setZoomTargetX(double zoomTargetX) {
        this.zoomTargetX = zoomTargetX;
    }

    public double getZoomTargetY() {
        return zoomTargetY;
    }

    public void setZoomTargetY(double zoomTargetY) {
        this.zoomTargetY = zoomTargetY;
    }

    public double getShootInterval() {
        return shootInterval;
    }

    public void setShootInterval(double shootInterval) {
        this.shootInterval = shootInterval;
    }

    public int getShootCount() {
        return shootCount;
    }

    public void setShootCount(int shootCount) {
        this.shootCount = shootCount;
    }

    public String getAlternatePointSecurityHeight() {
        return alternatePointSecurityHeight;
    }

    public void setAlternatePointSecurityHeight(String alternatePointSecurityHeight) {
        this.alternatePointSecurityHeight = alternatePointSecurityHeight;
    }

    public String getAlternatePointHeight() {
        return alternatePointHeight;
    }

    public void setAlternatePointHeight(String alternatePointHeight) {
        this.alternatePointHeight = alternatePointHeight;
    }

    public String getAlternatePointTimes() {
        return alternatePointTimes;
    }

    public void setAlternatePointTimes(String alternatePointTimes) {
        this.alternatePointTimes = alternatePointTimes;
    }

    public String getAlternatePointLat() {
        return alternatePointLat;
    }

    public void setAlternatePointLat(String alternatePointLat) {
        this.alternatePointLat = alternatePointLat;
    }

    public String getAlternatePointLon() {
        return alternatePointLon;
    }

    public void setAlternatePointLon(String alternatePointLon) {
        this.alternatePointLon = alternatePointLon;
    }

    public int getAELockEnabled() {
        return AELockEnabled;
    }

    public void setAELockEnabled(int AELockEnabled) {
        this.AELockEnabled = AELockEnabled;
    }

    public int getCameraExposureMode() {
        return cameraExposureMode;
    }

    public void setCameraExposureMode(int cameraExposureMode) {
        this.cameraExposureMode = cameraExposureMode;
    }

    public int getCameraExposureCompensation() {
        return cameraExposureCompensation;
    }

    public void setCameraExposureCompensation(int cameraExposureCompensation) {
        this.cameraExposureCompensation = cameraExposureCompensation;
    }

    public String getMegaphoneWord() {
        return megaphoneWord;
    }

    public void setMegaphoneWord(String megaphoneWord) {
        this.megaphoneWord = megaphoneWord;
    }

    public int getMegaphoneVolume() {
        return megaphoneVolume;
    }

    public void setMegaphoneVolume(int megaphoneVolume) {
        this.megaphoneVolume = megaphoneVolume;
    }

    public int getMegaphonePlayMode() {
        return megaphonePlayMode;
    }

    public void setMegaphonePlayMode(int megaphonePlayMode) {
        this.megaphonePlayMode = megaphonePlayMode;
    }

    public int getIsGuidingFlight() {
        return isGuidingFlight;
    }

    public void setIsGuidingFlight(int isGuidingFlight) {
        this.isGuidingFlight = isGuidingFlight;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit) {
        this.heightLimit = heightLimit;
    }

    public int getDistanceLimitEnabled() {
        return distanceLimitEnabled;
    }

    public void setDistanceLimitEnabled(int distanceLimitEnabled) {
        this.distanceLimitEnabled = distanceLimitEnabled;
    }

    public int getDistanceLimit() {
        return distanceLimit;
    }

    public void setDistanceLimit(int distanceLimit) {
        this.distanceLimit = distanceLimit;
    }

    public int getCameraVideoStreamSource() {
        return cameraVideoStreamSource;
    }

    public void setCameraVideoStreamSource(int cameraVideoStreamSource) {
        this.cameraVideoStreamSource = cameraVideoStreamSource;
    }

    public int getThermalZoomRatios() {
        return thermalZoomRatios;
    }

    public void setThermalZoomRatios(int thermalZoomRatios) {
        this.thermalZoomRatios = thermalZoomRatios;
    }

    public int getCameraZoomRatios() {
        return cameraZoomRatios;
    }

    public void setCameraZoomRatios(int cameraZoomRatios) {
        this.cameraZoomRatios = cameraZoomRatios;
    }

    public int getCameraMode() {
        return cameraMode;
    }

    public void setCameraMode(int cameraMode) {
        this.cameraMode = cameraMode;
    }


    public int getLiveStreamQuality() {
        return liveStreamQuality;
    }

    public void setLiveStreamQuality(int liveStreamQuality) {
        this.liveStreamQuality = liveStreamQuality;
    }

    public int getStreamIndex() {
        return streamIndex;
    }

    public void setStreamIndex(int streamIndex) {
        this.streamIndex = streamIndex;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUpload_url() {
        return upload_url;
    }

    public void setUpload_url(String upload_url) {
        this.upload_url = upload_url;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(int msg_type) {
        this.msg_type = msg_type;
    }

    public String getKmz_url() {
        return kmz_url;
    }

    public void setKmz_url(String kmz_url) {
        this.kmz_url = kmz_url;
    }

    public String getRtmp_push_url() {
        return rtmp_push_url;
    }

    public void setRtmp_push_url(String rtmp_push_url) {
        this.rtmp_push_url = rtmp_push_url;
    }



}
