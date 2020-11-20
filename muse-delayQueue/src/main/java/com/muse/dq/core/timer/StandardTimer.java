package com.muse.dq.core.timer;


import com.google.gson.Gson;
import com.muse.dq.core.HashNode;
import com.muse.dq.model.Job;
import com.muse.dq.util.RedisUtil;
import com.muse.dq.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Slf4j
@Component
public class StandardTimer extends BaseTimer {
    public static final String STANDARD_TIMER = "standard:timer:";

    public static final String CONSUME_LIST = "consume:list";

    StandardTimer() {
        super("standard-timer");
    }

    @Override
    public void scan() {
        Gson gson = SpringUtil.getBean(Gson.class);
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        List<String> realNodes = HashNode.getRealNodes();
        realNodes.forEach(realNode -> {
            long currentTime = System.currentTimeMillis();
            Set<ZSetOperations.TypedTuple<String>> jobIds = redisUtil.zRangeByScoreWithScores(realNode, 0, currentTime + 1000);
            jobIds.forEach(jobId -> {
                if (currentTime >= Objects.requireNonNull(jobId.getScore()).longValue()) {
                    String jobStr = redisUtil.get(jobId.getValue());
                    log.info("job: " + jobStr + " is ok, waiting to consume");
                    moveJobToConsumeList(jobId.getValue());
                }
            });
        });
    }

    public void moveJobToConsumeList(String jobId) {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        redisUtil.lLeftPush(CONSUME_LIST, jobId);
    }
}
