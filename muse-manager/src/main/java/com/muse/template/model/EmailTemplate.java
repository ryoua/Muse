package com.muse.template.model;

import com.muse.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_email_template")
public class EmailTemplate extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String templateName;
    @Column
    private String title;
    @Column
    private String copy;
    @Column
    private String content;
}
