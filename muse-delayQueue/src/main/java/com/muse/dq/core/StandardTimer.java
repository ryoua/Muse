package com.muse.dq.core;


import com.google.gson.Gson;
import com.muse.dq.util.RedisUtil;
import com.muse.dq.util.SpringUtil;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/18
 **/
public class StandardTimer extends BaseTimer {
    public static final String STANDARD_TIMER = "standard:timer:";


    @Override
    public void scan() {
        Gson gson = SpringUtil.getBean(Gson.class);
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);


    }
}
