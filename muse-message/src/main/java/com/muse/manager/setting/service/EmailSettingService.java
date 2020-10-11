package com.muse.manager.setting.service;

import com.muse.auth.threadlocal.UserThreadLocal;
import com.muse.manager.setting.mapper.EmailSettingMapper;
import com.muse.manager.setting.model.EmailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Service
public class EmailSettingService {
    @Autowired
    EmailSettingMapper emailSettingMapper;

    public void addEmailSetting(EmailSetting emailSetting) {
        Long userId = UserThreadLocal.getCurrentUser();
        emailSetting.setUid(userId);
        emailSettingMapper.addEmailSetting(emailSetting);
    }

    public void deleteEmailSetting(long id) {
        emailSettingMapper.deleteEmailSettingById(id);
    }

//    public List<EmailSetting> getAllEmailSetting() {
//        return emailSettingMapper.getAllEmailSetting();
//    }

    public EmailSetting getEmailSettingById(long id) {
        return emailSettingMapper.getEmailSettingById(id);
    }

    public void updateEmailSetting(EmailSetting emailSetting) {
        emailSettingMapper.updateEmailSetting(emailSetting);
    }
}
