package com.muse.dq.core.timer;


import com.google.gson.Gson;
import com.muse.dq.core.HashNode;
import com.muse.dq.model.Job;
import com.muse.dq.model.JobStatus;
import com.muse.dq.util.RedisUtil;
import com.muse.dq.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public void scan() {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        List<String> realNodes = HashNode.getRealNodes();
        // 对每个Node做一个循环
        realNodes.forEach(realNode -> {
            // 拿到Node里时间最早的节点
            long currentTime = System.currentTimeMillis();
            Set<ZSetOperations.TypedTuple<String>> jobIds = redisUtil.zRangeByScoreWithScores(realNode, 0, currentTime + 1000);
            jobIds.forEach(jobId -> {
                // 检查时间是否到了
                if (currentTime >= Objects.requireNonNull(jobId.getScore())) {
                    // 将任务从zSet移到消费列表
                    redisUtil.zRemove(realNode, jobId.getValue());
                    log.info("job: " + jobId.getValue() + " is ok, waiting to consume");
                    moveJobToConsumeList(jobId.getValue());
                }
            });
        });
    }

    public void moveJobToConsumeList(String jobId) {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        redisUtil.lLeftPush(CONSUME_LIST, jobId);
    }

    public boolean checkStatus(String jobId) {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        Gson gson = SpringUtil.getBean(Gson.class);

        String jobStr = redisUtil.get(JOB_POOL + jobId);
        Job job = gson.fromJson(jobStr, Job.class);
        return job.getStatus() != JobStatus.DELETE;
    }
}
