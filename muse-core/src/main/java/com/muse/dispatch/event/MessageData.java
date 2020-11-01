package com.muse.dispatch.event;


/**
 * * @Author: RyouA
 * * @Date: 2020/11/1
 **/
public class MessageData {
    private long messageId;

    /**
     * 消息名称
     */
    private String name;

    /**
     * 消息类型
     */
    private int type;

    /**
     * 内容参数
     */
    private String message;

    /**
     * 接受者
     */
    private String receiver;
}
