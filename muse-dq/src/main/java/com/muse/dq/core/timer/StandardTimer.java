package com.muse.dq.core.timer;


import com.google.gson.Gson;
import com.muse.dq.core.HashNode;
import com.muse.dq.model.Job;
import com.muse.dq.model.JobStatus;
import com.muse.utils.RedisUtil;
import com.muse.utils.SpringUtil;
import com.muse.utils.TypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import java.util.*;

import static com.muse.dq.core.JobPool.JOB_POOL;

/**
 * 定时扫描器
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Slf4j
@Component
public class StandardTimer extends BaseTimer {

    public static final String CONSUME_LIST = "consume:list";

    StandardTimer() {
        super("standard-timer");
    }

    /**
     * 每秒扫描
     */
    @Override
    public void scan() {
        double current = TypeUtil.reverseLongToDouble(System.currentTimeMillis());
        List<String> delayList = new ArrayList<>();
        // 对每个bucket尾部数据做一个循环, 拿出时间到的
        List<Set<ZSetOperations.TypedTuple<String>>> lastData = getLastData();
        lastData.forEach(data -> {
            data.forEach(item -> {
                Double score = item.getScore();
                assert score != null;
                if (score <= current) {
                    delayList.add(item.getValue());
                    log.info("job id: " + item.getValue() + " is ok, time lost[" + (current - item.getScore()) + "]");
                }
            });
        });

        if (!delayList.isEmpty()) {
            moveDelayJob(delayList);
        }
    }

    public void moveDelayJob(List<String> jobs) {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        StringRedisTemplate redisTemplate = redisUtil.getRedisTemplate();
        // 对每个Node做一个循环
        redisTemplate.executePipelined(new RedisCallback<Long>() {
            @Override
            public Long doInRedis( RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                jobs.forEach(jobId -> {
                    redisUtil.lLeftPush(CONSUME_LIST, jobId);
                });
                redisConnection.closePipeline();
                return null;
            }
        });
    }

    /**
     * 获取每个Node Bucket的最后一个数据
     * @return
     */
    public List<Set<ZSetOperations.TypedTuple<String>>> getLastData() {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        List<String> realNodes = HashNode.getRealNodes();
        StringRedisTemplate redisTemplate = redisUtil.getRedisTemplate();
        List<Set<ZSetOperations.TypedTuple<String>>> data = new ArrayList<>();
        // 对每个Node做一个循环
        redisTemplate.executePipelined(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                realNodes.forEach(realNode -> {
                    Set<ZSetOperations.TypedTuple<String>> typedTuples = redisUtil.zRangeWithScores(realNode, 0, 1);
                    data.add(typedTuples);
                });
                redisConnection.closePipeline();
                return null;
            }
        });
        return data;
    }

    public boolean checkStatus(String jobId) {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        Gson gson = SpringUtil.getBean(Gson.class);

        String jobStr = redisUtil.get(JOB_POOL + jobId);
        Job job = gson.fromJson(jobStr, Job.class);
        return job.getStatus() != JobStatus.DELETE;
    }
}
