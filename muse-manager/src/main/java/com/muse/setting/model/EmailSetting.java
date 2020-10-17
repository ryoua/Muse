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
    @Column
    private Long uid;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String port;
    @Column
    private String account;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Boolean isSSL;
    @Column
    private Boolean isTLS;
    @Column
    private String remark;
}
