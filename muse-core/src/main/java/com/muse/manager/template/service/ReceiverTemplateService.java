package com.muse.manager.template.service;

import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.repository.ReceiverTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Service
public class ReceiverTemplateService {
    @Autowired
    ReceiverTemplateRepository receiverTemplateRepository;

    public List<ReceiverTemplate> getAllReceiverTemplate(int pageNo, int pageSize) {
        long uid = UserLocal.getUserId();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ReceiverTemplate> all = receiverTemplateRepository.findAllByUid(uid, pageable);
        return all.getContent();
    }

    public void deleteReceiverTemplateById(long id) {
        receiverTemplateRepository.deleteById(id);
    }

    public void updateReceiverTemplate(ReceiverTemplate receiverTemplate) {
        long uid = UserLocal.getUserId();
        receiverTemplate.setUid(uid);
        receiverTemplateRepository.save(receiverTemplate);
    }

    public ReceiverTemplate addReceiverTemplate(ReceiverTemplate receiverTemplate) {
        long uid = UserLocal.getUserId();
        receiverTemplate.setUid(uid);
        return receiverTemplateRepository.save(receiverTemplate);
    }

    public void updateReceiverTemplateStatus(int status, long id) {

    }
}
