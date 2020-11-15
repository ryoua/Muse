package com.muse.manager.setting.service;

import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.setting.mapper.EmailSettingMapper;
import com.muse.manager.setting.model.EmailSetting;
import com.muse.manager.setting.model.EmailSettingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/15
 **/
@Service
public class EmailSettingService {
    @Autowired
    private EmailSettingMapper emailSettingMapper;

    public EmailSetting getEmailSetting() {
        EmailSettingExample emailSettingExample = new EmailSettingExample();
        emailSettingExample.or().andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        return emailSettingMapper.selectByExample(emailSettingExample).get(0);
    }

    public void addEmailSetting(EmailSetting emailSetting) {
        if (getEmailSetting() == null) {
            emailSetting.setId(getEmailSetting().getId());
            updateEmailSetting(emailSetting);
        } else {
            emailSetting.setUid(UserLocal.getUserId());
            emailSettingMapper.insertSelective(emailSetting);
        }
    }

    public void deleteEmailSetting(long id) {
        emailSettingMapper.deleteByPrimaryKey(id);
    }

    public void updateEmailSetting(EmailSetting emailSetting) {
        emailSettingMapper.updateByPrimaryKeySelective(emailSetting);
    }
}
