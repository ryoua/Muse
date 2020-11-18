package com.muse.dq.core;

import com.muse.dq.model.Job;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
public class JobHandler implements Handler {
    @Autowired
    JobPool jobPool;
    @Autowired
    JobBucket jobBucket;

    @Override
    public void handle() {

    }

    @Override
    public void handle(Object task) {
        Job job = (Job) task;
        jobPool.add(job);
        jobBucket.addJobToBucket();
    }
}
