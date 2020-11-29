package com.muse.manager.message.model;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/26
 **/
public class MessageSendStep {
    /**
     * 刚创建完成
     */
    public static final int CREATED = 1;

    /**
     * 校验
     */
    public static final int VERIFY = 2;

    /**
     * 统一调度
     */
    public static final int DISPATCH = 3;

    /**
     * 发送
     */
    public static final int SEND = 4;

    /**
     * 发送完成
     */
    public static final int FINISHED = 5;
}
