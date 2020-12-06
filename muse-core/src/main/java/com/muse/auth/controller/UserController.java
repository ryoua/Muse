package com.muse.auth.controller;

import com.muse.auth.model.User;
import com.muse.auth.service.UserService;
import com.muse.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/auth/login")
    public Result login(@RequestBody User user) {
        if (userService.login(user)) {
            String token = UUID.randomUUID().toString();
            return Result.SUCCESS(token);
        } else {
            return Result.FAIL();
        }
    }
}
