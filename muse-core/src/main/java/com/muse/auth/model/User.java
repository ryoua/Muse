package com.muse.auth.model;

import com.muse.common.model.BaseModel;
import lombok.Data;

import javax.persistence.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Data
@Entity
@Table(name = "a_user")
public class User extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
