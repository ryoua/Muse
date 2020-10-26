package com.muse.dispatch;

import com.lmax.disruptor.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
@Slf4j
public class HandlerException implements ExceptionHandler {


    /**
     * 运行过程中发生时的异常
     */
    @Override
    public void handleEventException(Throwable ex, long sequence, Object event) {
        ex.printStackTrace();
        log.error("process data error sequence ==[{}] event==[{}] ,ex ==[{}]", sequence, event.toString(), ex.getMessage());
    }

    /**
     * 启动时的异常
     */
    @Override
    public void handleOnStartException(Throwable ex) {
        log.error("start disruptor error ==[{}]!", ex.getMessage());
    }

    /**
     * 关闭时的异常
     */
    @Override
    public void handleOnShutdownException(Throwable ex) {
        log.error("shutdown disruptor error ==[{}]!", ex.getMessage());
    }

}
