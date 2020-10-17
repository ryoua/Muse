package com.muse.setting.service;

import com.muse.setting.model.EmailSetting;
import com.muse.setting.repository.EmailSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Service
public class EmailSettingService {
    @Autowired
    EmailSettingRepository emailSettingRepository;

    public void addEmailSetting(EmailSetting emailSetting) {
        emailSettingRepository.save(emailSetting);
    }

    public List<EmailSetting> getAllEmailSetting() {
        return emailSettingRepository.findAll();
    }

}
