package com.ryoua.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@Slf4j
@Component
public class OkHttpUtil {
    private static OkHttpClient okHttpClient;

    @Autowired
    public OkHttpUtil(OkHttpClient okHttpClient) {
        OkHttpUtil.okHttpClient = okHttpClient;
    }

    /**
     * get
     * @param url 请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return
     */
    public static String get(String url, Map<String, String> queries) {
        String responseBody = "";
        StringBuilder sb = new StringBuilder(url);
        if (queries.isEmpty()) {
            boolean firstFlag = true;
            for (Map.Entry entry : queries.entrySet()) {
                if (firstFlag) {
                    sb.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                    firstFlag = false;
                } else {
                    sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        }
        Request request = new Request.Builder().url(sb.toString()).build();
        Response response = null;
        try {
            log.info("====okhttp send=====: " + url + " :::: " + queries);
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            log.error("okhttp3 put error >> ex = {}", e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responseBody;
    }

    /**
     * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"} 参数一：请求Url 参数二：请求的JSON
     * 参数三：请求回调
     */
    public static Response postJsonParams(String url, String jsonParams) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = null;
        try {
            log.info("okhttp send: " + url + " :::: " + jsonParams);
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response;
            }
        } catch (Exception e) {
            log.error("okhttp3 post error >> ex = {}", e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return response;
    }
}
