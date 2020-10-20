package com.muse.message.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/19
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_message_send_info")
public class MessageSendInfo {
}
