package com.muse.message.repository;

import com.muse.message.model.MessageSend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
public interface MessageSendRepository extends JpaRepository<MessageSend, Long> {
}
