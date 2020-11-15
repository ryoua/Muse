package com.muse.manager.setting.service;

import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.setting.mapper.EmailSettingMapper;
import com.muse.manager.setting.model.EmailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/15
 **/
@Service
public class EmailSettingService {
    @Autowired
    private EmailSettingMapper emailSettingMapper;

    public void addEmailSetting(EmailSetting emailSetting) {
        emailSetting.setUid(UserLocal.getUserId());
        emailSettingMapper.insertSelective(emailSetting);
    }

    public void deleteEmailSetting(long id) {
        emailSettingMapper.deleteByPrimaryKey(id);
    }

    public void updateEmailSetting(EmailSetting emailSetting) {
        emailSettingMapper.updateByPrimaryKeySelective(emailSetting);
    }
}
