package com.muse.dq.core.timer;


import com.google.gson.Gson;
import com.muse.dq.core.HashNode;
import com.muse.dq.model.Job;
import com.muse.dq.util.RedisUtil;
import com.muse.dq.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Slf4j
public class StandardTimer extends BaseTimer {
    public static final String STANDARD_TIMER = "standard:timer:";

    StandardTimer() {
        super("standard-timer");
    }

    @Override
    public void scan() {
        Gson gson = SpringUtil.getBean(Gson.class);
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        List<String> realNodes = HashNode.getRealNodes();
        realNodes.forEach(realNode -> {
            Set<ZSetOperations.TypedTuple<String>> jobIds = redisUtil.zRangeWithScores(realNode, 0, 0);
            long currentTime = System.currentTimeMillis();
            jobIds.forEach(jobId -> {
                if (currentTime >= Objects.requireNonNull(jobId.getScore()).longValue()) {
                    String jobStr = redisUtil.get(jobId.getValue());
                    log.info("job: " + jobStr + "is ok, waiting to consume");
                }
            });
        });
    }
}
