package com.muse.dq.core;

import com.muse.dq.controller.ApiController;
import com.muse.dq.core.timer.Timer;
import com.muse.dq.model.Job;
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
    @Autowired
    JobPool jobPool;
    @Autowired
    ApiController apiController;

    @Override

    public void run(String... args) throws Exception {
        for (int i = 0; i < 50000; i++) {
            Job job = new Job();
            job.setId(String.valueOf(i));
            job.setBody("===" + i + "===");
            job.setDelay(1L);
            apiController.add(job);
        }

        Thread.sleep(5000);
//        while (true) {
//            timer.scan();
//        }
    }
}
