package com.muse.dq.core;

import com.muse.dq.core.lifecycle.LifeCycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程初始化类
 * * @Author: RyouA
 * * @Date: 2020/11/23
 **/
public class ThreadInit implements LifeCycle {
    private List<Runnable> threads = new ArrayList<>();

    /**
     * 注册任务
     * @param runnable
     */
    public void register(Runnable runnable) {
        threads.add(runnable);
    }

    /**
     * 线程初始化
     */
    public void init() {
        threads.forEach(thread -> {
            new Thread(thread).start();
        });
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
