package com.muse.auth.controller;

import com.muse.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/25
 **/
@RestController
@RequestMapping("/auth/user")
public class UserController {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
    }
}
