package com.muse.dispatch;

import com.google.gson.Gson;
import com.muse.dispatch.worker.EmailEventWorker;
import com.muse.dispatch.worker.SmsEventWorker;
import com.muse.manager.message.model.MessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/1
 **/
@Component
public class Dispatcher {
    @Autowired
    Gson gson;
    @Autowired
    EmailEventWorker emailEventWorker;
    @Autowired
    SmsEventWorker smsEventWorker;

    public void dispatch(MessageSend messageSend) {
        // 提取参数

        // 黑白名单过滤

        // 时间调度

        // 发送给生产者
    }
}
