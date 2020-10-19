package com.muse.setting.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.muse.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_settings_email")
@Entity
public class EmailSetting extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(64) comment '邮箱名称'")
    private String name;
    @Column(nullable = false, columnDefinition = "varchar(32) comment 'smtp服务器地址'")
    private String address;
    @Column(nullable = false, columnDefinition = "varchar(32) comment 'smtp服务器端口'")
    private String port;
    @Column
    private String account;
    @Column(nullable = false, columnDefinition = "varchar(32) comment '发件邮箱'")
    private String username;
    @Column(nullable = false, columnDefinition = "varchar(32) comment '授权码'")
    private String password;
    @Column
    private Boolean isSSL;
    @Column
    private Boolean isTLS;
    @Column
    private String remark;
}
