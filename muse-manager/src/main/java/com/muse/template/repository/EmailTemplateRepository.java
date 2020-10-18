package com.muse.template.repository;

import com.muse.template.model.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {

}
