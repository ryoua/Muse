package com.muse.message.service;

import com.google.gson.Gson;
import com.muse.exception.MuseException;
import com.muse.message.model.MessageType;
import com.muse.message.model.vo.MessageSendVo;
import com.muse.message.repository.MessageSendRepository;
import com.muse.template.model.EmailTemplate;
import com.muse.template.repository.EmailTemplateRepository;
import com.muse.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/17
 **/
@Service
public class MessageService {
    @Autowired
    MessageSendRepository messageSendRepository;
    @Autowired
    EmailTemplateRepository emailTemplateRepository;
    @Autowired
    Gson gson;

    @Transactional(rollbackOn = Exception.class)
    public int send(MessageSendVo messageSendVo) {
        handleParam(messageSendVo);
        handleReceiver(messageSendVo);
        dispatch();
    }

    public void handleParam(MessageSendVo messageSendVo) {
        String templateId = messageSendVo.getParamTemplateId();
        boolean haveParamTemplate = StringUtil.isNotNull(templateId);
        if (haveParamTemplate) {
            switch (messageSendVo.getMessageType()) {
                case MessageType.EMAIL: {
                    EmailTemplate emailTemplate = emailTemplateRepository.findById(Long.parseLong(templateId)).orElse(null);
                    if (emailTemplate == null) {
                        throw new MuseException("找不到对应的参数模板");
                    } else {
                        messageSendVo.setParam(gson.toJson(emailTemplate));
                    }
                    break;
                }
                case MessageType.SMS: {

                }
                default: {
                    break;
                }
            }
        }
    }

    public void handleReceiver(MessageSendVo messageSendVo) {

    }
}
