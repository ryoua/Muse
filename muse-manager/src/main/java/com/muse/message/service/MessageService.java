package com.muse.message.service;

import com.google.gson.Gson;
import com.muse.exception.MuseException;
import com.muse.message.model.MessageType;
import com.muse.message.model.vo.MessageSendVo;
import com.muse.message.repository.MessageSendRepository;
import com.muse.template.model.EmailTemplate;
import com.muse.template.repository.EmailTemplateRepository;
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
}
