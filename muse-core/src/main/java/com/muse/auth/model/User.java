package com.muse.auth.model;

import com.muse.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/25
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "a_user")
public class User extends BaseModel {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, columnDefinition = "varchar(64) comment '用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "varchar(64) comment '密码'")
    private String password;

    @Column(nullable = false, columnDefinition = "varchar(64) comment '盐'")
    private String salt;
}
