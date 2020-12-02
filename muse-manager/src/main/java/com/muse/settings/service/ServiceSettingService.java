package com.muse.settings.service;

import com.muse.settings.mapper.ServiceSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * * @Author: RyouA
 * * @Date: 2020/12/2
 **/
@Service
public class ServiceSettingService {
    @Autowired
    private ServiceSettingMapper serviceSettingMapper;

}
