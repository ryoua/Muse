package com.muse.dispatcher.service;

import com.muse.manager.c.model.BatchSendParam;
import com.muse.dispatcher.model.SendParam;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/7
 **/
public interface ISendService {
    /**
     * 相同文案，发给0~N 人
     * @param sendParam
     */
    void send(SendParam sendParam);

    /**
     * 不同文案，发给不同人，一次可接收多组
     * @param batchSendParam
     */
    void send(BatchSendParam batchSendParam);
}
