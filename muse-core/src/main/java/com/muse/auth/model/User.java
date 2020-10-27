package com.muse.auth.model;

import com.muse.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/25
 **/
@Getter
@Setter

public class User extends BaseModel {
    private long id;

    private String username;

    private String password;

    private String salt;
}
