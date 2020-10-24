package com.muse.common.queue;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/23
 **/
public abstract class BaseQueueHelper<D, E extends ValueWrapper<D>, H extends WorkHandler<E>> {
    /**
     * 保存所有的队列, 用于退出时清理资源
     */
    private static List<BaseQueueHelper> queueHelperList = new ArrayList<>();

    /**
     * disruptor对象
     */
    private Disruptor<E> disruptor;

    /**
     * 时间轮
     */
    private RingBuffer<E> ringBuffer;

    /**
     * initQueue
     */
    private List<D> initQueue = new ArrayList<>();

    /**
     * 队列大小, 必须为2的幂
     * @return
     */
    protected abstract int getQueueSize();

    /**
     * 事件工厂
     * @return
     */
    protected abstract EventFactory<E> eventFactory();

    /**
     * 时间消费者
     * @return
     */
    protected abstract WorkHandler[] getHandler();

    /**
     * 获取策略
     * @return
     */
    protected abstract WaitStrategy getStrategy();

    /**
     * 初始化
     */
    public void init() {
//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("disruptorThreadPool").build();
//        disruptor = new Disruptor<E>(eventFactory(), getQueueSize(), threadFactory, ProducerType.SINGLE, getStrategy());
//        disruptor.setDefaultExceptionHandler();
//        disruptor.handleEventsWithWorkerPool(getHandler());
//        ringBuffer = disruptor.start();
    }

}
