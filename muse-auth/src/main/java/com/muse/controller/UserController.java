package com.muse.controller;

import com.muse.model.Result;
import com.muse.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户相关接口
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private static final String AUTH_TAG = "auth";
    @PostMapping("/login")
    @ApiOperation(value = "登录", tags = AUTH_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    public Result<?> login(HttpServletResponse response, @RequestBody User user) {
        return Result.SUCCESS();
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册", tags = AUTH_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    public Result<?> register(@RequestBody User user) {
        return Result.SUCCESS();
    }
}
