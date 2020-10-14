package com.muse.setting.service;

import com.muse.auth.threadlocal.UserThreadLocal;
import com.muse.setting.mapper.EmailSettingMapper;
import com.muse.setting.model.EmailSetting;
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

    public int addEmailSetting(EmailSetting emailSetting) {
        Long userId = UserThreadLocal.getCurrentUser();
        emailSetting.setUid(userId);
        return emailSettingMapper.addEmailSetting(emailSetting);
    }

    public int deleteEmailSetting(long id) {
        return emailSettingMapper.deleteEmailSettingById(id);
    }

//    public List<EmailSetting> getAllEmailSetting() {
//        return emailSettingMapper.getAllEmailSetting();
//    }

    public EmailSetting getEmailSettingById(long id) {
        Long userId = UserThreadLocal.getCurrentUser();
        return emailSettingMapper.getEmailSettingById(userId, id);
    }

    public int updateEmailSetting(EmailSetting emailSetting, long id) {
        emailSetting.setId(id);
        return emailSettingMapper.updateEmailSetting(emailSetting);
    }
}
