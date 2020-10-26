package com.muse.dispatch.worker;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkHandler;
import com.muse.dispatch.event.EventFactory;
import com.muse.dispatch.event.MessageData;
import com.muse.dispatch.event.MessageDataEvent;
import com.muse.dispatch.consumer.EmailEventConsumer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
@Component
public class EmailEventWorker extends BaseQueueWorker<MessageData, MessageDataEvent, EmailEventConsumer> implements InitializingBean {

    private static final int QUEUE_SIZE = 1024;

    @Autowired
    private List<EmailEventConsumer> emailEventConsumers;


    @Override
    protected int getQueueSize() {
        return QUEUE_SIZE;
    }

    @Override
    protected EventFactory eventFactory() {
        return new EventFactory();
    }

    @Override
    protected WorkHandler[] getHandler() {
        int size = emailEventConsumers.size();
        EmailEventConsumer[] paramEventHandlers = (EmailEventConsumer[]) emailEventConsumers.toArray(new EmailEventConsumer[size]);
        return paramEventHandlers;
    }

    @Override
    protected WaitStrategy getStrategy() {
        return new BlockingWaitStrategy();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.init();
    }
}
