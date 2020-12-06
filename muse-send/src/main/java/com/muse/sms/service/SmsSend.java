package com.muse.sms.service;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/3
 **/
public interface SmsSend {
    /**
     * 发小消息
     * @param phoneNumber
     * @return
     */
    public String sendMessage(String phoneNumber);
}
