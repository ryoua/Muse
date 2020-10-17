package com.muse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
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
    private String id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String salt;
}
