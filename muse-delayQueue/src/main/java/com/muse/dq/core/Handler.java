package com.muse.dq.core;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
public interface Handler {
    /**
     * 任务处理
     */
    public void handle();

    /**
     * 任务处理
     * @param task
     */
    public void handle(Object task);
}
