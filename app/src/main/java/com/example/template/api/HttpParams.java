package com.example.template.api;

import android.support.v4.util.ArrayMap;

import java.util.Map;

/**
 * Description:
 * Creator: Chenqiang
 * Date: 2018/1/27
 */

public class HttpParams {

    /**
     * 请求默认携带的数据
     *
     * @return ParamMap
     */
    public static Map<String, String> getParamMap() {
        Map<String, String> map = new ArrayMap<>();
        return map;
    }

}
