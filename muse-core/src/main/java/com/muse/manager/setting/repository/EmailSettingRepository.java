package com.muse.manager.setting.repository;

import com.muse.manager.setting.model.EmailSetting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Mapper
public interface EmailSettingRepository {
    EmailSetting findByIdAndUid(long id, long uid);

    void deleteByIdAndUid(long id, long uid);

    List<EmailSetting> findAllByUid(long uid);
}
