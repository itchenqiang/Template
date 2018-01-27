package com.example.template.api;

import com.example.template.net.callback.Callback;
import com.example.template.net.log.LoggerInterceptor;
import com.example.template.net.utils.OkHttpUtils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * Description: OKHttp辅助类
 * Creator: Chenqiang
 * Date: 2018/1/27
 */

public class HttpHelper {

    private static final HttpHelper sHttpHelper = new HttpHelper();
    private final OkHttpUtils mOkHttpUtils;

    public static HttpHelper getInstance() {
        return sHttpHelper;
    }

    private HttpHelper() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
                .readTimeout(20000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("okHttp"))
                .build();
        mOkHttpUtils = OkHttpUtils.initClient(okHttpClient);
    }

    /**
     * get请求
     *
     * @param obj      请求类
     * @param partUrl  请求地址
     * @param id       请求网络的标识
     * @param paramMap 请求参数，没有传null
     * @param callback 回调
     */
    public static void get(Object obj, String partUrl, int id, Map<String, String> paramMap, Callback<String> callback) {
        OkHttpUtils
                .get()
                .url(getAbsoluteUrl(partUrl))
                .tag(obj)
                .id(id)
                .params(paramMap)
                .build()
                .execute(callback);
    }

    /**
     * json方式post请求
     *
     * @param obj        请求类
     * @param partUrl    请求地址
     * @param id         请求网络的标识
     * @param JsonString 请求参数
     * @param callback   回调
     */
    public static void postJson(Object obj, String partUrl, int id, String JsonString, Callback<String> callback) {
        OkHttpUtils
                .postString()
                .url(getAbsoluteUrl(partUrl))
                .tag(obj)
                .id(id)
                .content(JsonString)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(callback);
    }

    /**
     * 普通POST
     *
     * @param obj      请求类
     * @param partUrl  请求地址
     * @param id       请求网络的标识
     * @param paramMap 请求参数，没有传null
     * @param callback 回调
     */
    public static void postString(Object obj, String partUrl, int id, Map<String, String> paramMap, Callback<String> callback) {
        OkHttpUtils
                .post()
                .url(getAbsoluteUrl(partUrl))
                .tag(obj)
                .id(id)
                .params(paramMap)
                .build()
                .execute(callback);
    }

    /**
     * 上传文件
     *
     * @param partUrl  请求地址
     * @param file     文件（图片。。。）
     * @param id       请求网络的标识
     * @param callback 回调
     */
    public static void postFile(String partUrl, int id, File file, Callback<String> callback) {
        OkHttpUtils
                .postFile()
                .url(getAbsoluteUrl(partUrl))
                .id(id)
                .file(file)
                .build()
                .execute(callback);
    }

    /**
     * 上传表单
     *
     * @param partUrl  请求地址
     * @param id       请求网络的标识
     * @param key      请求文件key upload:上传头像的key
     * @param file     文件（图片。。。）
     * @param callback 回调
     */
    public static void postForm(String partUrl, int id, String key, File file,
                                Map<String, String> params, Callback<String> callback) {
        OkHttpUtils.post()
                .addFile(key, file.getName(), file)
                .url(getAbsoluteUrl(partUrl))
                .params(params)
                .id(id)
                .build()
                .execute(callback);
    }

    /**
     * 上传表单(包含多张图片)
     *
     * @param partUrl  请求地址
     * @param id       请求网络的标识
     * @param key      请求文件key upload:上传头像的key
     * @param fileMap  图片
     * @param callback 回调
     */
    public static void postForms(String partUrl, int id, String key, Map<String, File> fileMap,
                                 Map<String, String> params, Callback<String> callback) {
        OkHttpUtils.post()
                .files(key, fileMap)
                .url(getAbsoluteUrl(partUrl))
                .params(params)
                .id(id)
                .build()
                .execute(callback);
    }

    /**
     * 下载
     *
     * @param partUrl  请求地址
     * @param id       请求网络的标识
     * @param callback 回调
     */
    public static void downloadFile(String partUrl, int id, Callback<File> callback) {
        OkHttpUtils
                .get()
                .url(getAbsoluteUrl(partUrl))
                .id(id)
                .build()
                .execute(callback);
    }

    public void cancelRequest(Object obj) {
        if (mOkHttpUtils != null) {
            mOkHttpUtils.cancelTag(obj);
        }
    }

    private static String getAbsoluteUrl(String partUrl) {
        return HostManage.getServerHost() + partUrl;
    }

}
