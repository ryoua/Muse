package com.muse.dispatch.filter;

import com.muse.manager.message.model.MessageSend;

/**
 * 阀接口，用作过滤器
 * * @Author: RyouA
 * * @Date: 2020/11/21
 **/
public interface Valve {
    /**
     * 阀的信息
     * @return
     */
    String getInfo();

    /**
     * 调用
     * @param messageSend
     * @param valveContext
     */
    void invoke(MessageSend messageSend, ValveContext valveContext);
}
