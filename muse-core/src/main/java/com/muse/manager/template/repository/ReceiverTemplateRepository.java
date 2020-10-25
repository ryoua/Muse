package com.muse.manager.template.repository;

import com.muse.manager.template.model.ReceiverTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Repository
public interface ReceiverTemplateRepository extends PagingAndSortingRepository<ReceiverTemplate, Long> {
    Page<ReceiverTemplate> findAllByUid(long uid, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update m_receiver_template r set r.status = :#{status} where r.uid = :#{id}")
    void updateReceiverTemplateStatusById(int status, long id);
}
