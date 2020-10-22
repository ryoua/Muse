package com.muse.manager.setting.mapper;

import com.muse.manager.setting.model.EmailSetting;
import org.apache.ibatis.annotations.Param;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
public interface EmailSettingMapper {
    EmailSetting selectById(@Param("id") long id, @Param("uid") long uid);

    int deleteById(@Param("id") long id, @Param("uid") long uid);

    int update(EmailSetting emailSetting);
}
