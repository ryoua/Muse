package com.muse.dispatch.event;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
@Getter
@Setter
public class MessageDataEvent extends ValueWrapper<MessageData>  {
    /**
     * 消息流水号
     */
    private int transactionId;

    /**
     * 时间戳
     */
    private long timestamp;
}
