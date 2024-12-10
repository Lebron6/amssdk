package com.aros.arossdk.api;


public class FlightState {

    private int msg_type = 60013;
    private String homepointLat;//返航点经纬度
    private String homepointLong;

    private int distance;//距离航点
    private double egm96Altitude;//海拔高度
    private String horizontalSpeed;//水平速度
    private String verticalSpeed;//垂直速度
    private int windSpeed;//风速
    private int satelliteNumber;//卫星数量
    private String GPSSignalLevel;//GPS信号等级
    private int remoteControlSignal;//遥控器信号
    private int pictureBiographySignal;//图传信号
    private int electricityInfoA;//A电量信息
    private int voltageInfoA;//A电压信息
    private double batteryTemperatureA;//A电池温度
    private int electricityInfoB;//B电量信息
    private int voltageInfoB;//B电压信息
    private double batteryTemperatureB;//B电池温度
    private String planeMessage;//飞机提示信息
    private String warningMessage;//飞机警告信息
    private int angleYaw;//飞机飞行机头角度
    private String flightPathName;//航线名称

    private String flightId;//航线id
    private String waypointMissionExecuteState;//航线执行状态
    private boolean airlineFlight;//是否航线飞行
    private int flightPathStatus;//航线状态航线状态 （0 航线飞行中 1 航线暂停中 2航线已终止）
    private int goHomeState;//返航执行状态  0未触发返航 1返航中 2返航下降中 3返航完成
    private long timestamp;//时间戳
    private String missionName;//当前正在执行的航线名
    private int currentWaypointIndex;//当前航点下标
    private String currentLongitude;//当前经度
    private String currentLatitude;//当前纬度
    private double flyingHeight;//飞行高度
    private String roll;//机身姿态
    private String pitch;
    private String yaw;
    private String gimbalRoll;//云台角度
    private String gimbalPitch;
    private String gimbalYaw;

    protected int getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(int msg_type) {
        this.msg_type = msg_type;
    }

    protected String getHomepointLat() {
        return homepointLat;
    }

    public void setHomepointLat(String homepointLat) {
        this.homepointLat = homepointLat;
    }

    protected String getHomepointLong() {
        return homepointLong;
    }

    public void setHomepointLong(String homepointLong) {
        this.homepointLong = homepointLong;
    }

    protected int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    protected double getEgm96Altitude() {
        return egm96Altitude;
    }

    public void setEgm96Altitude(double egm96Altitude) {
        this.egm96Altitude = egm96Altitude;
    }

    protected String getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public void setHorizontalSpeed(String horizontalSpeed) {
        this.horizontalSpeed = horizontalSpeed;
    }

    protected String getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(String verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    protected int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    protected int getSatelliteNumber() {
        return satelliteNumber;
    }

    public void setSatelliteNumber(int satelliteNumber) {
        this.satelliteNumber = satelliteNumber;
    }

    protected String getGPSSignalLevel() {
        return GPSSignalLevel;
    }

    public void setGPSSignalLevel(String GPSSignalLevel) {
        this.GPSSignalLevel = GPSSignalLevel;
    }

    protected int getRemoteControlSignal() {
        return remoteControlSignal;
    }

    public void setRemoteControlSignal(int remoteControlSignal) {
        this.remoteControlSignal = remoteControlSignal;
    }

    protected int getPictureBiographySignal() {
        return pictureBiographySignal;
    }

    public void setPictureBiographySignal(int pictureBiographySignal) {
        this.pictureBiographySignal = pictureBiographySignal;
    }

    protected int getElectricityInfoA() {
        return electricityInfoA;
    }

    public void setElectricityInfoA(int electricityInfoA) {
        this.electricityInfoA = electricityInfoA;
    }

    protected int getVoltageInfoA() {
        return voltageInfoA;
    }

    public void setVoltageInfoA(int voltageInfoA) {
        this.voltageInfoA = voltageInfoA;
    }

    protected double getBatteryTemperatureA() {
        return batteryTemperatureA;
    }

    public void setBatteryTemperatureA(double batteryTemperatureA) {
        this.batteryTemperatureA = batteryTemperatureA;
    }

    protected int getElectricityInfoB() {
        return electricityInfoB;
    }

    public void setElectricityInfoB(int electricityInfoB) {
        this.electricityInfoB = electricityInfoB;
    }

    protected int getVoltageInfoB() {
        return voltageInfoB;
    }

    public void setVoltageInfoB(int voltageInfoB) {
        this.voltageInfoB = voltageInfoB;
    }

    protected double getBatteryTemperatureB() {
        return batteryTemperatureB;
    }

    public void setBatteryTemperatureB(double batteryTemperatureB) {
        this.batteryTemperatureB = batteryTemperatureB;
    }

    protected String getPlaneMessage() {
        return planeMessage;
    }

    public void setPlaneMessage(String planeMessage) {
        this.planeMessage = planeMessage;
    }

    protected String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    protected int getAngleYaw() {
        return angleYaw;
    }

    public void setAngleYaw(int angleYaw) {
        this.angleYaw = angleYaw;
    }

    protected String getFlightPathName() {
        return flightPathName;
    }

    public void setFlightPathName(String flightPathName) {
        this.flightPathName = flightPathName;
    }

    protected String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    protected String getWaypointMissionExecuteState() {
        return waypointMissionExecuteState;
    }

    public void setWaypointMissionExecuteState(String waypointMissionExecuteState) {
        this.waypointMissionExecuteState = waypointMissionExecuteState;
    }

    protected boolean isAirlineFlight() {
        return airlineFlight;
    }

    public void setAirlineFlight(boolean airlineFlight) {
        this.airlineFlight = airlineFlight;
    }

    protected int getFlightPathStatus() {
        return flightPathStatus;
    }

    public void setFlightPathStatus(int flightPathStatus) {
        this.flightPathStatus = flightPathStatus;
    }

    protected int getGoHomeState() {
        return goHomeState;
    }

    public void setGoHomeState(int goHomeState) {
        this.goHomeState = goHomeState;
    }

    protected long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    protected String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    protected int getCurrentWaypointIndex() {
        return currentWaypointIndex;
    }

    public void setCurrentWaypointIndex(int currentWaypointIndex) {
        this.currentWaypointIndex = currentWaypointIndex;
    }

    protected String getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(String currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    protected String getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(String currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    protected double getFlyingHeight() {
        return flyingHeight;
    }

    public void setFlyingHeight(double flyingHeight) {
        this.flyingHeight = flyingHeight;
    }

    protected String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    protected String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    protected String getYaw() {
        return yaw;
    }

    public void setYaw(String yaw) {
        this.yaw = yaw;
    }

    protected String getGimbalRoll() {
        return gimbalRoll;
    }

    public void setGimbalRoll(String gimbalRoll) {
        this.gimbalRoll = gimbalRoll;
    }

    protected String getGimbalPitch() {
        return gimbalPitch;
    }

    public void setGimbalPitch(String gimbalPitch) {
        this.gimbalPitch = gimbalPitch;
    }

    protected String getGimbalYaw() {
        return gimbalYaw;
    }

    public void setGimbalYaw(String gimbalYaw) {
        this.gimbalYaw = gimbalYaw;
    }
}
