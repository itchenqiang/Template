package com.example.template.api;

import com.example.template.constant.ApkConstants;

/**
 * Created by Administrator on 2018/1/27.
 */

public class HostManage {

    public static String getServerHost() {
        if (ApkConstants.DEBUG) {
            return "";
        }
        return null;
    }
}
