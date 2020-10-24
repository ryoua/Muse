package com.muse.manager.setting.model;

import com.muse.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


/**
 * 邮箱设置
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_email_setting")
public class EmailSetting extends BaseModel {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "bigint comment '主键'")
    private Long id;

    @Column(nullable = false, columnDefinition = "bigint comment '用户id'")
    private Long uid;

    @Column(nullable = false, columnDefinition = "varchar(255) comment '邮箱名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(255) comment '邮箱服务器地址'")
    private String address;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '邮箱服务器端口'")
    private String port;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '发件人'")
    private String account;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '邮箱用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '邮箱密码'")
    private String password;

    @Column(columnDefinition = "bit default 0 comment '是否开启SSL'")
    private Boolean isSSL;

    @Column(columnDefinition = "bit default 0 comment '是否开启TLS'")
    private Boolean isTLS;

    @Column(columnDefinition = "varchar(255) comment '备注'")
    private String remark;
}
