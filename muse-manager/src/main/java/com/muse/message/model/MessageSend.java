package com.muse.message.model;

import com.muse.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_message_send")
public class MessageSend extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long uid;
    @Column
    private String messageType;
    @Column
    private String messageName;
    @Column
    private Long emailTemplateId;
    @Column
    private String emailParam;
    @Column
    private String receiverTemplateId;
    @Column
    private String receivers;
    @Column
    private String sql;
}
