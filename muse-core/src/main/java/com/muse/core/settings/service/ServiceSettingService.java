package com.muse.core.settings.service;

import com.google.gson.Gson;
import com.muse.common.model.RedisConstants;
import com.muse.common.threadLocal.UserLocal;
import com.muse.common.util.RedisUtil;
import com.muse.core.settings.mapper.ServiceSettingMapper;
import com.muse.core.settings.model.ServiceSetting;
import com.muse.core.settings.model.ServiceSettingExample;
import com.muse.core.settings.model.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/2
 **/
@Service
public class ServiceSettingService {
    @Autowired
    private ServiceSettingMapper serviceSettingMapper;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    Gson gson;

    public List<ServiceSetting> getEmailSettingByFactory(String factory) {
        ServiceSettingExample serviceSettingExample = new ServiceSettingExample();
        serviceSettingExample.or()
                .andUidEqualTo(UserLocal.getUserId())
                .andValidEqualTo(true)
                .andTypeEqualTo(ServiceType.EMAIL)
                .andFactoryEqualTo(factory);
        return serviceSettingMapper.selectByExample(serviceSettingExample);
    }

    public void addEmailSetting(ServiceSetting serviceSetting) {
        ServiceSettingExample serviceSettingExample = new ServiceSettingExample();
        serviceSettingExample.or()
                .andUidEqualTo(UserLocal.getUserId())
                .andValidEqualTo(true)
                .andTypeEqualTo(ServiceType.EMAIL)
                .andFactoryEqualTo(serviceSetting.getFactory());
        List<ServiceSetting> serviceSettings = serviceSettingMapper.selectByExample(serviceSettingExample);
        if (serviceSettings.isEmpty()) {
            serviceSetting.setType(ServiceType.EMAIL);
            serviceSetting.setUid(UserLocal.getUserId());
            serviceSettingMapper.insertSelective(serviceSetting);
        } else {
            serviceSetting.setId(serviceSettings.get(0).getId());
            serviceSetting.setType(ServiceType.EMAIL);
            serviceSetting.setUid(UserLocal.getUserId());
            serviceSettingMapper.updateByPrimaryKeySelective(serviceSetting);
        }
    }
}
