package com.muse.dq.core;

import com.google.gson.Gson;
import com.muse.dq.model.Job;
import com.muse.dq.model.RedisConstants;
import com.muse.dq.util.RedisUtil;
import com.muse.dq.util.SpringUtil;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Component
public class AckHandler implements Handler {
    public static final int MESSAGE_ACK_WAIT_OUT_TIME = 10;

    @Override
    public void handle() {
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        Gson gson = SpringUtil.getBean(Gson.class);

        while (true) {
            // 获取确认失败的消息
            String failAck = redisUtil.lBLeftPop(RedisConstants.MESSAGE_ACK_FAIL_LIST, MESSAGE_ACK_WAIT_OUT_TIME, TimeUnit.SECONDS);
            Job job = gson.fromJson(failAck, Job.class);

        }
    }
}