package com.muse.dq.core;

import com.google.gson.Gson;
import com.muse.dq.model.Job;
import com.muse.dq.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Slf4j
public class JobBucket {
    private static final String JOB_BUCKET = "job:bucket:";

    @Autowired
    Gson gson;
    @Autowired
    RedisUtil redisUtil;

    public void addJobToBucket(Job job) {
        String id = job.getId();
        String bucket = HashNode.getBucket(id);
        redisUtil.zAdd(bucket, id, changeDelayTimeToAbsTime(job.getDelay()));
    }


    public Long changeDelayTimeToAbsTime(Long delay) {
        return System.currentTimeMillis() + delay * 1000;
    }


}
