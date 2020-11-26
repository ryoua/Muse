package com.muse.manager.statistics.service;

import com.muse.common.util.RedisUtil;
import com.muse.manager.message.mapper.MessageSendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/24
 **/
@Service
public class StatisticsService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private MessageSendMapper messageSendMapper;

    public static final String SEND_NUM_TODAY = "send:num:";

    public Long sendNumToday() {
        Date date = new Date();
        String num = redisUtil.get(SEND_NUM_TODAY + date.getDay());
        if (StringUtils.isEmpty(num)) {
            return messageSendMapper.countSendToday();
        } else {
            return Long.parseLong(num);
        }
    }
}
