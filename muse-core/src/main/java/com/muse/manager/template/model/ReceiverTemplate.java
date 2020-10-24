package com.muse.manager.template.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_receiver_template")
public class ReceiverTemplate extends Template {
    @Lob
    @Column(columnDefinition = "text comment '字符串形式的用户'")
    private String receivers;

    @Lob
    @Column(columnDefinition = "text comment 'sql格式的用户'")
    private String sqlStr;

    @Column(columnDefinition = "varchar(255) comment '文件形式的用户, 只保存url'")
    private String fileUrl;
}