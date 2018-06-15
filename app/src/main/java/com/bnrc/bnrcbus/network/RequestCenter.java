package com.bnrc.bnrcbus.network;

import com.bnrc.bnrcbus.module.version.VersionModel;
import com.bnrc.bnrcsdk.okhttp.CommonOkHttpClient;
import com.bnrc.bnrcsdk.okhttp.listener.DisposeDataHandler;
import com.bnrc.bnrcsdk.okhttp.listener.DisposeDataListener;
import com.bnrc.bnrcsdk.okhttp.request.CommonRequest;
import com.bnrc.bnrcsdk.okhttp.request.RequestParams;

/**
 * Created by apple on 2018/5/31.
 */

public class RequestCenter {

    //根据参数发送所有post请求
    public static void postRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> clazz) {
        CommonOkHttpClient.post(CommonRequest.
                createPostRequest(url, params), new DisposeDataHandler(listener, clazz));
    }

    public static void requestVersionData(DisposeDataListener listener) {

        RequestParams params = new RequestParams();
        params.put("V", "2.3");
        params.put("appV", "1.4");
        params.put("Tm","1");

        RequestCenter.postRequest(HttpConstants.VERSION_URL, params, listener, VersionModel.class);
    }

}
