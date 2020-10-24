package com.muse.manager.setting.service;

import com.muse.manager.setting.model.EmailSetting;
import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.setting.repository.EmailSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@Service
public class EmailSettingService {
    @Autowired
    private EmailSettingRepository emailSettingRepository;

    public EmailSetting getEmailSettingById(long id) {
        long uid = UserLocal.getUserId();
        return emailSettingRepository.findByIdAndUid(id, uid);
    }

    public List<EmailSetting> getAllEmailSetting() {
        long uid = UserLocal.getUserId();
        return emailSettingRepository.findAllByUid(uid);
    }

    public void deleteEmailSettingById(long id) {
        long uid = UserLocal.getUserId();
        emailSettingRepository.deleteByIdAndUid(id, uid);
    }

    public void updateEmailSettingById(EmailSetting emailSetting) {
        emailSetting.setUid(UserLocal.getUserId());
        emailSettingRepository.save(emailSetting);
    }

    public long addEmailSetting(EmailSetting emailSetting) {
        emailSetting.setUid(UserLocal.getUserId());
        return emailSettingRepository.save(emailSetting).getId();
    }
}
