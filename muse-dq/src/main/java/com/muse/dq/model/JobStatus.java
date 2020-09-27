package com.muse.dq.model;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/27
 **/
public enum JobStatus {
    /**
     * 已经就绪
     */
    READY,
    /**
     * 被延迟
     */
    DELAY,
    /**
     * 已被消费
     */
    RESERVED,
    /**
     * 已被删除
     */
    DELETED;
}
