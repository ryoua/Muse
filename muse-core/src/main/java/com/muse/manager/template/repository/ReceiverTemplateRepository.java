package com.muse.manager.template.repository;

import com.muse.manager.template.model.ReceiverTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Repository
public interface ReceiverTemplateRepository extends JpaRepository<ReceiverTemplate, Long> {
}
