package com.muse.dq.core;

import com.google.gson.Gson;
import com.muse.dq.model.Job;
import com.muse.dq.utils.RedisUtil;
import com.muse.dq.utils.TypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Slf4j
@Component
public class JobBucket {

    @Autowired
    Gson gson;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 添加任务到Bucket中
     * @param job
     */
    public void addJobToBucket(Job job) {
        String id = job.getId();
        String bucket = HashNode.getBucket(id);
        redisUtil.zAdd(bucket, id, changeDelayTimeToAbsTime(job.getDelay()));
    }

    /**
     * 批量添加任务到Bucket中
     * @param jobs
     */
    public void addJobsToBucket(List<Job> jobs) {
        if (!jobs.isEmpty()) {
            Set<TypedTuple<String>> jobSet = new HashSet<>();
            String id = jobs.get(0).getId();
            jobs.forEach(job -> {
                Double score = TypeUtil.reverseLongToDouble(changeDelayTimeToAbsTime(job.getDelay()));
                TypedTuple<String> typedTuple = new DefaultTypedTuple<>(job.getId(), score);
                jobSet.add(typedTuple);

            });
            redisUtil.zAdd(id, jobSet);
        }
    }

    /**
     * 将延迟时间转为绝对时间
     * @param delay
     * @return
     */
    public Long changeDelayTimeToAbsTime(Long delay) {
        return System.currentTimeMillis() + delay * 1000;
    }
}
