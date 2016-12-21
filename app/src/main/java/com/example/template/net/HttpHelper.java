package com.example.template.net;

import com.example.template.net.callback.Callback;
import com.example.template.net.log.LoggerInterceptor;
import com.example.template.net.utils.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 网络请求
 * Created by chen on 2016/12/20.
 */

public class HttpHelper {

    private static HttpHelper httpHelper = new HttpHelper();

    public static HttpHelper getHttpHelper() {
        return httpHelper;
    }

    private HttpHelper() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("http:"))
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public static void get(String url, Callback<String> callback) {
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(callback);
    }
}
