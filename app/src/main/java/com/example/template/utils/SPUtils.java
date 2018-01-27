package com.example.template.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.template.application.MyApplication;


/**
 * Description: SharedPreference辅助类
 * Creator: Chenqiang
 * Date: 2018/1/27
 */

public class SPUtils {

    private static final String CONFIG = "config";

    /**
     * 获取SharedPreferences实例对象
     *
     * @param fileName sp文字
     */
    private synchronized static SharedPreferences getSharedPreference(String fileName) {
        return MyApplication.getContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * 保存一个String类型的值！
     */
    public synchronized static void putString(String key, String value) {
        SharedPreferences.Editor edit = getSharedPreference(CONFIG).edit();
        edit.putString(key, value).commit();
    }

    /**
     * 保存一个String类型的值！
     */
    public synchronized static void putString(String fileName, String key,
                                              String value) {
        SharedPreferences sp = getSharedPreference(fileName);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value).commit();
    }

    /**
     * 获取String的value
     */
    public synchronized static String getString(String key, String defValue) {
        return getSharedPreference(CONFIG).getString(key, defValue);
    }

    /**
     * 获取String的value
     */
    public synchronized static String getString(String fileName,
                                                String key, String defValue) {
        return getSharedPreference(fileName).getString(key, defValue);
    }

    /**
     * 保存一个Boolean类型的值！
     */
    public synchronized static void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor edit = getSharedPreference(CONFIG).edit();
        edit.putBoolean(key, value).commit();
    }

    /**
     * 获取boolean的value
     */
    public synchronized static boolean getBoolean(String key, Boolean defValue) {
        return getSharedPreference(CONFIG).getBoolean(key, defValue);
    }

    /**
     * 保存一个int类型的值！
     */
    public synchronized static void putInt(String key, int value) {
        SharedPreferences.Editor edit = getSharedPreference(CONFIG).edit();
        edit.putInt(key, value).commit();
    }

    /**
     * 获取int的value
     */
    public synchronized static int getInt(String key, int defValue) {
        return getSharedPreference(CONFIG).getInt(key, defValue);
    }

    /**
     * 保存一个float类型的值！
     */
    public synchronized static void putFloat(String fileName, String key, float value) {
        SharedPreferences.Editor edit = getSharedPreference(CONFIG).edit();
        edit.putFloat(key, value).commit();
    }

    /**
     * 获取float的value
     */
    public synchronized static float getFloat(String key, Float defValue) {
        return getSharedPreference(CONFIG).getFloat(key, defValue);
    }

    /**
     * 保存一个long类型的值！
     */
    public synchronized static void putLong(String key, long value) {
        SharedPreferences.Editor edit = getSharedPreference(CONFIG).edit();
        edit.putLong(key, value).commit();
    }

    /**
     * 获取long的value
     */
    public synchronized static long getLong(String key, long defValue) {
        return getSharedPreference(CONFIG).getLong(key, defValue);
    }

    /**
     * 清空对应key数据
     */
    public synchronized static void remove(String key) {
        SharedPreferences.Editor edit = getSharedPreference(CONFIG).edit();
        edit.remove(key).commit();
    }

    /**
     * 清空数据
     */
    public synchronized static void clear(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            fileName = CONFIG;
        }
        SharedPreferences.Editor edit = getSharedPreference(fileName).edit();
        edit.clear().commit();
    }

}
