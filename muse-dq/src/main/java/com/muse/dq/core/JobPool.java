package com.muse.dq.core;

import com.google.gson.Gson;
import com.muse.dq.model.Job;
import com.muse.dq.model.JobStatus;
import com.muse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;

import static com.muse.dq.model.RedisConstants.JOB_POOL;

/**
 * 任务池 只存放任务的JSON格式数据
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@ThreadSafe
@Component
public class JobPool {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    Gson gson;

    /**
     * 新增任务
     * @param job
     */
    public void add(Job job) {
        redisUtil.set(JOB_POOL + job.getId(), gson.toJson(job));
    }

    /**
     * 使用Pipeline批量新增任务
     * @param jobs
     */
    public void batchAdd(List<Job> jobs) {
        StringRedisTemplate redisTemplate = redisUtil.getRedisTemplate();
        redisTemplate.executePipelined(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                jobs.forEach(job -> {
                    redisUtil.set(JOB_POOL + job.getId(), gson.toJson(job));
                });
                redisConnection.closePipeline();
                return null;
            }
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

    public Job getJobDetail(String jobId) {
        String job = redisUtil.get(jobId);
        return gson.fromJson(job, Job.class);
    }

    public boolean isJobDelete(Job job) {
        return job.getStatus() == JobStatus.DELETE;
    }
}
