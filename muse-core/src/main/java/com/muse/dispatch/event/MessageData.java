package com.muse.dispatch.event;


import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/1
 **/
@Getter
@Setter
public class MessageData {

    private long id;

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
