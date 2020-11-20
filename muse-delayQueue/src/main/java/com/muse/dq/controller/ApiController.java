package com.muse.dq.controller;

import com.muse.dq.core.JobBucket;
import com.muse.dq.core.JobPool;
import com.muse.dq.model.Job;
import com.muse.dq.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/19
 **/
@RestController
public class ApiController {
    @Autowired
    private JobPool jobPool;

    @Autowired
    private JobBucket jobBucket;

    @PostMapping("/job")
    public Result addJob(@RequestBody Job job) {
        jobPool.add(job);
        jobBucket.addJobToBucket(job);
        return Result.SUCCESS();
    }
}
