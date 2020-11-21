package com.muse.dispatch.filter;

import com.muse.manager.message.model.MessageSend;

/**
 * 管道接口
 * * @Author: RyouA
 * * @Date: 2020/11/21
 **/
public interface Pipeline {
    /**
     * 获取基础阀
     */
    void getBasic();

    /**
     * 设置基础阀
     * @param valve
     */
    void setBasic(Valve valve);

    /**
     * 增加阀
     * @param valve
     */
    void addValve(Valve valve);

    /**
     * 获取全部阀
     * @return
     */
    Valve[] getValves();

    /**
     * 移除阀
     * @param valve
     */
    void removeValve(Valve valve);

    /**
     * 调用
     * @param messageSend
     */
    void invoke(MessageSend messageSend);
}
