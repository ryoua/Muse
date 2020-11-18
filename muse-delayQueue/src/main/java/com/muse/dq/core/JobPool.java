package com.muse.dq.core;

import com.google.gson.Gson;
import com.muse.dq.model.Job;
import com.muse.dq.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
@Component
public class JobPool {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    Gson gson;

    private static final String JOB_POOL = "job:pool:";

    public void add(Job job) {
    }

    public void batchAdd(List<Job> jobs) {

    }

    public void delete(String id) {
    }

    public void batchDelete(List<String> ids) {
    }
}
