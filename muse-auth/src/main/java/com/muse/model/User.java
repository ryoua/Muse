package com.muse.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "a_user")
@Entity
public class User extends BaseModel {

    @Id
    @Column(nullable = false, columnDefinition = "varchar(64) comment 'Id, 雪花算法生成'")
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '密码'")
    private String password;

}
