package com.muse.manager.setting.repository;

import com.muse.manager.setting.model.EmailSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Repository
public interface EmailSettingRepository extends JpaRepository<EmailSetting, Long> {
    EmailSetting findByIdAndUid(long id, long uid);

    void deleteByIdAndUid(long id, long uid);

    List<EmailSetting> findAllByUid(long uid);
}
