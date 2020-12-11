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
@Table(name = "t_sms_template")
public class SmsTemplate extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long uid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cp;

    @Column(nullable = false)
    private String templateId;

}
