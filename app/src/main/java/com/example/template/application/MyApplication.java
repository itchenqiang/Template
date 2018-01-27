package com.example.template.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;


public class MyApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        SDKInitializer.initialize(this);
        initUmeng();
        initJpush();
    }

    private void initJpush() {
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
    }

    private void initUmeng() {
//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
//        MobclickAgent.openActivityDurationTrack(true);
//        // 设置是否对日志信息进行加密, 默认false(不加密)
//        MobclickAgent.enableEncrypt(true);
    }

    public static Context getContext() {
        return mContext;
    }
}
