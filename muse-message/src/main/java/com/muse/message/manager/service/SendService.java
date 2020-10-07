package com.muse.message.manager.service;

import com.muse.message.manager.model.BatchSendParam;
import com.muse.message.manager.model.SendParam;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/26
 **/
public interface SendService {
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
