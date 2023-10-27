package com.example.learnandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtils {

    private static SharedUtils mUtils;
    private SharedPreferences preferences;

    public static SharedUtils getInstance(Context ctx){
        if(mUtils == null){
            mUtils = new SharedUtils();
            mUtils.preferences = ctx.getSharedPreferences("shopping",Context.MODE_PRIVATE);
        }
        return mUtils;
    }

    public  void  writeBoolean(String key,boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public boolean readBoolean(String key,boolean defalutValue){
        return preferences.getBoolean(key,defalutValue);
    }

}
