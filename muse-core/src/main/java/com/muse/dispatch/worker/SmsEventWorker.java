package com.muse.dispatch.worker;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkHandler;
import com.muse.dispatch.event.EventFactory;
import com.muse.dispatch.event.MessageData;
import com.muse.dispatch.event.MessageDataEvent;
import com.muse.dispatch.consumer.SmsEventConsumer;
import com.muse.manager.message.model.MessageSend;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
public class SmsEventWorker extends BaseQueueWorker<MessageData, MessageDataEvent, SmsEventConsumer> implements InitializingBean {
    private static final int QUEUE_SIZE = 2048;

    @Autowired
    private List<SmsEventConsumer> smsEventConsumers;


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
        int size = smsEventConsumers.size();
        SmsEventConsumer[] paramEventHandlers = (SmsEventConsumer[]) smsEventConsumers.toArray(new SmsEventConsumer[size]);
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
