package com.muse.manager.template.repository;

import com.muse.manager.template.model.SmsTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Repository
public interface SmsTemplateRepository extends CrudRepository<SmsTemplate, Long> {
    Page<SmsTemplate> findByUidAndValid(long uid, boolean valid, Pageable var1);
}
