package com.muse.dispatch;

import com.google.gson.Gson;
import com.muse.dispatch.event.MessageData;
import com.muse.dispatch.worker.EmailEventWorker;
import com.muse.dispatch.worker.SmsEventWorker;
import com.muse.manager.message.model.MessageSend;
import com.muse.manager.message.model.MessageType;
import com.muse.manager.template.mapper.MessageTemplateMapper;
import com.muse.manager.template.mapper.ReceiverTemplateMapper;
import com.muse.manager.template.model.MessageTemplate;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.model.ReceiverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    ReceiverTemplateMapper receiverTemplateMapper;
    @Autowired
    MessageTemplateMapper messageTemplateMapper;

    public void dispatch(MessageSend messageSend) {
        // 提取参数

        // 黑白名单过滤

        // 时间调度

        // 发送给生产者
        sendToWorker(messageSend);
    }

    public void sendToWorker(MessageSend messageSend) {
        switch (messageSend.getMessageType()) {
            case MessageType.EMAIL: {
                dispatchEmail(messageSend);
                break;
            }
            default:
        }
    }

    public void dispatchEmail(MessageSend messageSend) {
        List<String> receivers = new ArrayList<>();

        if (messageSend.getReceiverIsTemplate()) {
            ReceiverTemplate receiverTemplate = receiverTemplateMapper.selectByPrimaryKey(Long.parseLong(messageSend.getReceiver()));
            if (receiverTemplate.getType().equals(ReceiverType.STRING)) {
                receivers = Arrays.stream(receiverTemplate.getContent().split(",")).collect(Collectors.toList());
            }
        }

        receivers.forEach(receiver -> {
            messageSend.setReceiver(receiver);
            MessageData messageData = changeMessageSendToEvent(messageSend);
            System.out.println(messageData);
            emailEventWorker.publishEvent(messageData);
        });
    }

    /**
     * 将视图的消息发送Bean转化为队列中的事件
     * @param messageSend
     * @return
     */
    public MessageData changeMessageSendToEvent(MessageSend messageSend) {
        MessageData messageData = new MessageData();
        messageData.setId(1);
        if (messageSend.getMessageIsTemplate()) {
            MessageTemplate messageTemplate = messageTemplateMapper.selectByPrimaryKey(Long.parseLong(messageSend.getMessage()));
            messageData.setMessage(messageTemplate.getContent());
        } else {
            messageData.setMessage(messageSend.getMessage());
        }
        messageData.setName(messageSend.getName());
        messageData.setType(1);
        messageData.setReceiver(messageSend.getReceiver());
        return messageData;
    }
}
