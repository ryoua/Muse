package com.muse.dispatch.consumer;

import com.google.gson.Gson;
import com.lmax.disruptor.WorkHandler;
import com.muse.dispatch.event.MessageData;
import com.muse.dispatch.event.MessageDataEvent;
import com.muse.manager.message.model.EmailMessage;
import com.muse.manager.message.model.EmailType;
import com.muse.send.email.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;

/**
 * 邮件消息消费
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
public class EmailEventConsumer implements WorkHandler<MessageDataEvent> {
    @Autowired
    private IMailService iMailService;
    @Autowired
    Gson gson;

    @Override
    public void onEvent(MessageDataEvent event) throws MessagingException {
        MessageData messageData = event.getValue();
        EmailMessage emailMessage = gson.fromJson(messageData.getMessage(), EmailMessage.class);
        switch (emailMessage.getType()) {
            case EmailType.NORMAL_EMAIL: {
                iMailService.sendSimpleMail(messageData.getReceiver(), emailMessage.getTitle(), emailMessage.getContent());
                break;
            }
            case EmailType.HTML_EMAIL: {
                iMailService.sendHtmlMail(messageData.getReceiver(), emailMessage.getTitle(), emailMessage.getContent());
                break;
            }
            default: {
                break;
            }
        }
    }
}
