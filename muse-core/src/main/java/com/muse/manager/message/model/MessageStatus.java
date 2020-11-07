package com.muse.manager.message.model;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
public enum MessageStatus {
    /**
     * 新创建
     */
    NEW(1),

    /**
     * 调度中
     */
    DISPATCHING(2),

    /**
     * 推送中
     */
    SENDING(3),

    /**
     * 发送成功
     */
    SUCCESS(4),

    /**
     * 发送失败
     */
    FAILED(5),

    /**
     * 下发结束
     */
    FINISHED(6),

    /**
     * 中止
     */
    ABORT(7);

    private int status;

    MessageStatus(int status) {
        this.status = status;
    }
}
