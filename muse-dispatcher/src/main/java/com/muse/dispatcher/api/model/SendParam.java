package com.muse.dispatcher.api.model;


import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@Getter
@Setter
public class SendParam {
    /**
     * 模板ID
     */
    private long templateId;

    /**
     * 消息参数
     */
    private MsgParam msgParam;
}
