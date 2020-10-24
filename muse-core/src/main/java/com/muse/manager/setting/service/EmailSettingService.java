package com.muse.manager.setting.service;

import com.muse.manager.setting.mapper.EmailSettingMapper;
import com.muse.manager.setting.model.EmailSetting;
import com.muse.common.threadLocal.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@Service
public class EmailSettingService {
    @Autowired
    private EmailSettingMapper emailSettingMapper;

    public EmailSetting selectById(long id) {
        long uid = UserLocal.getUserId();
        return emailSettingMapper.selectById(id, uid);
    }

    public void deleteById(long id) {
        long uid = UserLocal.getUserId();
        emailSettingMapper.deleteById(id, uid);
    }

    public void updateById(EmailSetting emailSetting) {
        emailSetting.setUid(UserLocal.getUserId());
        emailSettingMapper.update(emailSetting);
    }
}
