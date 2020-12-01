package com.muse.dq.model;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Getter
@Setter
public class Job {
    /**
     * 任务ID，全局唯一
     */
    private String id;

    /**
     * 任务类型，也就是业务名称
     */
    private String topic;

    /**
     * 需要延迟的时间，单位秒
     */
    private Long delay;

    /**
     * 超时时间
     */
    private String ttr;

    /**
     * cron表达式
     */
    private String cron;

    /**
     * 消息体
     */
    private String body;

    /**
     * 状态
     */
    private int status;

    /**
     * 是否需要消息确认机制
     */
    private boolean needAck;
}
