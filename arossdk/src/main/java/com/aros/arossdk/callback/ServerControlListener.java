package com.aros.arossdk.callback;


public interface ServerControlListener {
    boolean onQueryAircraftConnectStatus();

    void onDockActionReceive(String status);

    void onMissionFileReceive(int type, String flightId, String flightName,
                              String uploadUrl,String bucketName,String key,String sortiesId, String accessKey, String missionUrl);

    void onMissionPause(int type);

    void onMissionResume(int type);

    void onStartGoHome(int type);

    void onCancelGoHome(int type);

    void onMissionStop(int type);

    void onEmergencyLanding(int type);

    void onVirtualStickModeEnabled(int type,boolean enabled);

    void onVirtualStickAdvancedParamReceive(int type,double x,double y,double r,double z);

    void onGimbalRotateByRelativeAngle(int type,double x,double y);

    void onSwitchCameraVideoStreamSource(int type,int sourceType);

    void onSwitchCameraMode(int type,int cameraMode);


}