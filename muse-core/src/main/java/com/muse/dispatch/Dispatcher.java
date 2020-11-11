package com.muse.dispatch;

import com.google.gson.Gson;
import com.muse.common.util.FileUtil;
import com.muse.dispatch.event.MessageData;
import com.muse.dispatch.worker.EmailEventWorker;
import com.muse.dispatch.worker.SmsEventWorker;
import com.muse.manager.message.mapper.MessageSendDetailMapper;
import com.muse.manager.message.model.MessageSend;
import com.muse.manager.message.model.MessageSendDetail;
import com.muse.manager.message.model.MessageType;
import com.muse.manager.template.mapper.MessageTemplateMapper;
import com.muse.manager.template.mapper.ReceiverTemplateMapper;
import com.muse.manager.template.model.MessageTemplate;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.model.ReceiverType;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
    @Autowired
    MessageSendDetailMapper messageSendDetailMapper;

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
        getReceivers(messageSend).forEach(receiver -> {
            messageSend.setReceiver(receiver);
            MessageData messageData = changeMessageSendToEvent(messageSend);
            emailEventWorker.publishEvent(messageData);
            addMessageSendDetail(messageSend);
            log.debug("add email task: " + gson.toJson(messageSend) + " to worker");
        });
    }

    public void addMessageSendDetail(MessageSend messageSend) {
        MessageSendDetail messageSendDetail = new MessageSendDetail();
        messageSendDetail.setMid(messageSend.getId());
        messageSendDetail.setMessage(messageSend.getMessage());
        messageSendDetail.setDescription(messageSend.getDescription());
        messageSendDetail.setReceiver(messageSend.getReceiver());
        messageSendDetailMapper.insertSelective(messageSendDetail);
    }

    /**
     * 获取接收人群
     * @param messageSend
     * @return
     */
    public List<String> getReceivers(MessageSend messageSend) {
        if (messageSend.getReceiverIsTemplate()) {
            return getReceiversFromTemplate(messageSend.getReceiver());
        } else {
            return getReceiversFromContent(messageSend.getReceiverType(), messageSend.getReceiver());
        }
    }

    /**
     * 从模板中获取接收人群
     * @param templateId
     * @return
     */
    public List<String> getReceiversFromTemplate(String templateId) {
        ReceiverTemplate receiverTemplate = receiverTemplateMapper.selectByPrimaryKey(Long.parseLong(templateId));
        switch (receiverTemplate.getType()) {
            case ReceiverType.STRING: {
                return Arrays.stream(receiverTemplate.getContent().split(",")).collect(Collectors.toList());
            }
            case ReceiverType.FILE: {
                String receiver = FileUtil.readContentFromFile(receiverTemplate.getContent());
                return Arrays.stream(receiver.split(",")).collect(Collectors.toList());
            }
            case ReceiverType.SQL: {
                return new ArrayList<>();
            }
            default:
                return new ArrayList<>();
        }
    }

    /**
     * 直接从前端的参数中获取接收人群
     * @param receiverType
     * @param content
     * @return
     */
    public List<String> getReceiversFromContent(Integer receiverType, String content) {
        switch (receiverType) {
            case ReceiverType.STRING: {
                return Arrays.stream(content.split(",")).collect(Collectors.toList());
            }
            case ReceiverType.FILE: {
                return Arrays.stream(FileUtil.readContentFromFile(content).split(",")).collect(Collectors.toList());
            }
            case ReceiverType.SQL: {
                return new ArrayList<>();
            }
            default:
                return new ArrayList<>();
        }
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
