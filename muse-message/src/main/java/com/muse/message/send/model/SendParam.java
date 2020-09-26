package com.muse.message.send.model;

import lombok.Data;

/**
 * 群发单个消息时的消息体
 * * @Author: RyouA
 * * @Date: 2020/9/26
 **/
@Data
public class SendParam {
    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 消息参数
     */
    private MsgParam msgParam;
}
