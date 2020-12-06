package com.muse.manager.template.model;

import com.muse.common.model.BaseModel;
import lombok.Data;

import javax.persistence.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Data
@Entity
@Table(name = "t_email_template")
public class EmailTemplate extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String subject;

    @Column
    private String copy;

    @Column(nullable = false)
    private String content;
}
