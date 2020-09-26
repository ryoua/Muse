package com.muse.message.send.model;

import lombok.Data;

import java.util.List;

/**
 * 群发不同消息时的消息参数体
 * * @Author: RyouA
 * * @Date: 2020/9/26
 **/
@Data
public class BatchSendParam {
    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 消息参数
     */
    private List<MsgParam> msgParam;
}
