package com.muse.dq.core.timer;

import com.muse.dq.core.lifecycle.LifeCycle;
import com.muse.dq.core.timer.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Component
@Slf4j
public abstract class BaseTimer implements Timer, LifeCycle {
    private String name;

    public BaseTimer(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        log.info("[" + name + "] is start");
    }

    @Override
    public void destroy() {
        log.info("[" + name + "] is destroy");
    }
}
