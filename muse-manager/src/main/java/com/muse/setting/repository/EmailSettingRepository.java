package com.muse.setting.repository;

import com.muse.setting.model.EmailSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/15
 **/
@Repository
public interface EmailSettingRepository extends JpaRepository<EmailSetting, Long> {

}
