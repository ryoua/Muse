package com.muse.dispatch.event;

import com.muse.dispatch.event.MessageDataEvent;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/

public class EventFactory implements com.lmax.disruptor.EventFactory<MessageDataEvent> {


    @Override
    public MessageDataEvent newInstance() {
        return new MessageDataEvent();
    }
}
