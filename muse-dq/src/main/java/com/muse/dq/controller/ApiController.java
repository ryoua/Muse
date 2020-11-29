package com.muse.dq.controller;

import com.muse.dq.core.JobBucket;
import com.muse.dq.core.JobPool;
import com.muse.dq.model.Job;
import com.muse.dq.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result add(@RequestBody Job job) throws InterruptedException {
        jobPool.add(job);
        jobBucket.addJobToBucket(job);
        return Result.SUCCESS();
    }

    @PostMapping("/jobs")
    public Result adds(@RequestBody List<Job> jobs) {
        jobs.forEach(job -> {
            jobPool.add(job);
        });
        jobBucket.addJobsToBucket(jobs);
        return Result.SUCCESS();
    }

    @DeleteMapping("/job/{id}")
    public Result delete(@PathVariable("id") String id) {
        jobPool.delete(id);
        return Result.SUCCESS();
    }
//
//    @PostMapping("/ack/{id}")
//    public Result<String> getAck(@PathVariable("id") String id, @RequestParam("ack") boolean ack) {
//        if ()
//    }
}
