package com.muse.dq.core;

import com.muse.dq.core.timer.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * * @Author: RyouA
 * * @Date: 2020/11/20
 **/
@Component
public class BootStrap implements CommandLineRunner {
    @Autowired
    private Timer timer;

    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(3000);
        while (true) {
            timer.scan();
        }
    }
}
