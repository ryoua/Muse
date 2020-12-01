package com.muse.dq.core.ack;

import com.google.gson.Gson;
import com.muse.dq.core.JobPool;
import com.muse.dq.model.Job;
import com.muse.dq.model.RedisConstants;
import com.muse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/29
 **/
@Component
public class ReSendHandler implements Handler{
    public static final int MESSAGE_ACK_WAIT_OUT_TIME = 10;

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    Gson gson;
    @Autowired
    JobPool jobPool;

    @Override
    public void handle() {
        while (true) {
            // 获取确认失败的消息
            String failId = getFailAckId();
            Job jobDetail = jobPool.getJobDetail(failId);
            if (!jobPool.isJobDelete(jobDetail)) {

            }
        }
    }

    public String getFailAckId() {
        return redisUtil.lBLeftPop(RedisConstants.MESSAGE_ACK_FAIL_LIST, MESSAGE_ACK_WAIT_OUT_TIME, TimeUnit.SECONDS);
    }
}
