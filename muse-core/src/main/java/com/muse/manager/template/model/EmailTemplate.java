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
@Table(name = "m_email_template")
public class EmailTemplate extends Template {
    @Column(nullable = false, columnDefinition = "varchar(255) comment '邮箱标题'")
    private String title;

    @Column(nullable = false, columnDefinition = "varchar(255) comment '抄送'")
    private String copy;

    @Column(columnDefinition = "varchar(255) comment '附件url'")
    private String attachmentUrl;

    @Lob
    @Column(columnDefinition = "text comment '邮件正文'")
    private String content;
}
