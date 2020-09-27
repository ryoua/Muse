package com.muse.dq.model;

import lombok.Data;
import lombok.ToString;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/27
 **/
@Data
@ToString
public class Job {
    /**
     * Job唯一Id
     */
    private String id;

    /**
     * 业务名称
     */
    private String topic;

    /**
     * 延迟时间
     */
    private Long delay;

    /**
     * 绝对时间
     */
    private Long absTime;

    /**
     * 执行超时时间
     */
    private Long ttr;

    /**
     * 消息体, JSON格式
     */
    private String body;

    /**
     * 状态
     */
    private JobStatus status;
}

