package com.muse.manager.setting.mapper;

import com.muse.manager.setting.model.EmailSetting;
import org.apache.ibatis.annotations.Mapper;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@Mapper
public interface EmailSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(EmailSetting record);

    EmailSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmailSetting record);

    int updateByPrimaryKey(EmailSetting record);
}
