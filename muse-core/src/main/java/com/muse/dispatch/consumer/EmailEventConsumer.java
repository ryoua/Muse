package com.muse.dispatch.consumer;

import com.lmax.disruptor.WorkHandler;
import com.muse.dispatch.event.MessageDataEvent;
import com.muse.send.email.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
public class EmailEventConsumer implements WorkHandler<MessageDataEvent> {
    @Autowired
    private IMailService iMailService;

    @Override
    public void onEvent(MessageDataEvent event)  {

    }
}
