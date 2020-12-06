package com.muse.dq.test;

import com.muse.dq.controller.ApiController;
import com.muse.dq.core.JobPool;
import com.muse.dq.core.timer.Timer;
import com.muse.dq.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


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

        Set<Job> set = new HashSet<>();

//        int counter = 0;
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 10000; j++) {
//                counter++;
//                Job job = new Job();
//                job.setId(String.valueOf(counter));
//                job.setBody("===" + counter + "===");
//                job.setDelay((long) i);
//                apiController.add(job);
//                set.add(job);
//            }
//        }

        timer.scan();

//        System.out.println(set.size());
//        long start = System.currentTimeMillis();
//        while (true) {
//            long end = System.currentTimeMillis();
//            if (end - start >= 1000) {
//                System.out.println("现在的set容量为： " + set.size());
//            }
//            start = end;
//        }
    }
}
