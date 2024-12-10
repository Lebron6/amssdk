package com.aros.arossdk.callback;


public interface ServerControlListener {
    boolean onQueryAircraftConnectStatus();

    void onDockActionReceive(String status);

    void onMissionFileReceive(int type, String flightId, String flightName, String missionUrl);

    void onMissionPause(int type);

    void onMissionResume(int type);

    void onStartGoHome(int type);

    void onCancelGoHome(int type);

    void onMissionStop(int type);

    void onEmergencyLanding(int type);


}