package com.muse.dispatch.consumer;

import com.lmax.disruptor.WorkHandler;
import com.muse.dispatch.event.MessageDataEvent;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
public class EmailEventConsumer implements WorkHandler<MessageDataEvent> {
    @Override
    public void onEvent(MessageDataEvent event)  {
    }
}
