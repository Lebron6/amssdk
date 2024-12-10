package com.aros.arossdk.callback;

public interface MqttListener {
        void onConnectSuccess();

        void onConnectonFailure(String s);

        void onResponseException(int type,String exception);

    }