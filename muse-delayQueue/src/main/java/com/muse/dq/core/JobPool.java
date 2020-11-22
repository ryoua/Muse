package com.muse.dq.core;

import com.google.gson.Gson;
import com.muse.dq.model.Job;
import com.muse.dq.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 任务池 只存放任务的JSON格式数据
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Component
public class JobPool {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    Gson gson;

    public static final String JOB_POOL = "job:pool:";

    /**
     * 新增任务
     * @param job
     */
    public void add(Job job) {
        redisUtil.set(JOB_POOL + job.getId(), gson.toJson(job));
    }

    /**
     * 批量新增任务
     * @param jobs
     */
    public void batchAdd(List<Job> jobs) {
        jobs.forEach(job -> {
            redisUtil.set(JOB_POOL + job.getId(), gson.toJson(job));
        });
    }

    /**
     * 删除单个任务
     * @param id
     */
    public void delete(String id) {
        redisUtil.delete(JOB_POOL + id);
    }

    /**
     * 批量删除任务
     * @param ids
     */
    public void batchDelete(List<String> ids) {
        ids.stream().map(id -> id += JOB_POOL);
        redisUtil.delete(ids);
    }
}
