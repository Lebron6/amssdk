package com.aros.myapplication.util;

import android.content.Context;

import com.aros.myapplication.app.App;


public class SPUtil extends BasePreference {
    private String TAG = getClass().getSimpleName();

    private static SPUtil preferenceUtils;

    /**
     * 需要增加key就在这里新建
     */

    private final String UPLOAD_URL = "upload_url";
    private final String ACCESS_KEY = "access_key";
    private final String SECRET_KEY = "secret_key";
    private final String BUCKET_NAME = "bucket_name";
    private final String OBJECT_KEY = "object_key";
    private final String SORTIES_ID = "sortiesId";

    private SPUtil(Context context) {
        super(context);
    }

    public synchronized static SPUtil getInstance() {
        if (null == preferenceUtils) {
            preferenceUtils = new SPUtil(App.Companion.getApplication());
        }
        return preferenceUtils;
    }

    public void setMinIOConfig(String upload_url, String access_key, String secret_key, String bucket_name, String object_key, String sortiesId) {
        setString(UPLOAD_URL, upload_url);
        setString(ACCESS_KEY, access_key);
        setString(SECRET_KEY, secret_key);
        setString(BUCKET_NAME, bucket_name);
        setString(OBJECT_KEY, object_key);
        setString(SORTIES_ID, sortiesId);
    }

    public String getUploadUrl() {
        return getString(UPLOAD_URL);
    }

    public String getAccessKey() {
        return getString(ACCESS_KEY);
    }

    public String getSortiesId() {
        return getString(SORTIES_ID);
    }

    public String getBucketName() {
        return getString(BUCKET_NAME);
    }

    public String getObjectKey() {
        return getString(OBJECT_KEY);
    }

    public String getSecretKey() {
        return getString(SECRET_KEY);
    }
}