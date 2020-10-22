package com.muse.service;

import java.util.List;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
public interface MessageSendService {
    /**
     * 获取所有消息发送的名称, 用于做重复判断
     * @return list列表
     */
    List<String> getAllMessageSendName();

    /**
     * 发送消息
     * @param map 参数
     */
    void sendMessage(Map<String, String> map);

    boolean getSendNameIsExist(String sendName);
}
