package com.muse.message.send.service.Impl;

import com.muse.message.send.model.SendType;
import com.muse.message.send.service.Impl.email.EmailSendServiceImpl;
import com.muse.message.send.service.Impl.sms.SmsSendServiceImpl;
import com.muse.message.send.service.SendService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * * @Author: RyouA
 * * @Date: 2020/9/26
 **/
@Component
public class SendFactory {
    @Resource
    private SmsSendServiceImpl smsSendService;

    @Resource
    private EmailSendServiceImpl emailSendService;

    public SendService createSendClient(SendType sendType) {
        switch (sendType) {
            case SMS:
                return smsSendService;
            case EMAIL:
                return emailSendService;
            default:
                break;
        }
        return null;
    }
}
