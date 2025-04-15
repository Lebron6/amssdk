package com.aros.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

/**
 * SharePreference基类 
 * 这里只写了对最常用的三种基本数据类型的操作。 
 */  
public class BasePreference {

    private Context context;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String FILE_NAME = "userInfo";
  
    protected BasePreference(Context context) {
        this.context = context;  
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    protected void userLoginOut(){
        sp.edit().clear().commit();
    }
  
    protected void setString(String key, String value) {
        sp.edit().putString(key, value).apply();
    }  
  
    protected String getString(String key) {
        return sp.getString(key, null);  
    }  
  
    protected void setBoolean(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();  
    }  
  
    protected boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }  
  
    protected void setInt(String key, int value) {
        sp.edit().putInt(key, value).apply();  
    }  
  
    protected int getInt(String key) {
        return sp.getInt(key, 0);  
    }

    protected int getYearInt(String key){
        return sp.getInt(key, Calendar.getInstance().get(Calendar.YEAR));
    }
}  