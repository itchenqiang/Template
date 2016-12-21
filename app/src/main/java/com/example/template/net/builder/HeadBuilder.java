package com.example.template.net.builder;


import com.example.template.net.utils.OkHttpUtils;
import com.example.template.net.request.OtherRequest;
import com.example.template.net.request.RequestCall;

public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
