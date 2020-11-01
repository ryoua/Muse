package com.muse.dispatch;

import com.google.gson.Gson;
import com.muse.dispatch.worker.EmailEventWorker;
import com.muse.dispatch.worker.SmsEventWorker;
import com.muse.manager.message.model.MessageSend;
import com.muse.manager.template.model.ReceiverTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/1
 **/
public class Dispatcher {
    @Autowired
    Gson gson;
    @Autowired
    EmailEventWorker emailEventWorker;
    @Autowired
    SmsEventWorker smsEventWorker;

    public void dispatch(MessageSend messageSend) {
        String receiverJson = messageSend.getReceiverJson();
        ReceiverTemplate receiverTemplate = gson.fromJson(receiverJson, ReceiverTemplate.class);
        receiverTemplate.getTemplatetype();
    }

}
