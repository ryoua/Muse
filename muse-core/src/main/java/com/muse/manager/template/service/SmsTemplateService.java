package com.muse.manager.template.service;

import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.template.model.SmsTemplate;
import com.muse.manager.template.repository.SmsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Service
public class SmsTemplateService {
    @Autowired
    SmsTemplateRepository smsTemplateRepository;

    public void saveSmsTemplate(SmsTemplate smsTemplate) {
        smsTemplate.setUid(UserLocal.getUserId());
        smsTemplateRepository.save(smsTemplate);
    }

    public Page<SmsTemplate> findAllSmsTemplate(int page, int size) {
        PageRequest request = PageRequest.of(page, size);
        long uid = UserLocal.getUserId();
        return smsTemplateRepository.findByUidAndValid(uid, true, request);
    }
}
