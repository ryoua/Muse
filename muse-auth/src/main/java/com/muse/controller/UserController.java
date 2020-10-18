package com.muse.controller;

import com.muse.config.JwtIgnore;
import com.muse.exception.MuseException;
import com.muse.model.Audience;
import com.muse.model.Result;
import com.muse.model.User;
import com.muse.service.UserService;
import com.muse.util.TokenUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private Audience audience;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @JwtIgnore
    @ApiOperation(value = "登录", tags = AUTH_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    public Result<?> login(HttpServletResponse response, @RequestBody User user) {
        Long userId = userService.login(user);
        if (userId == null) {
            return Result.FAIL();
        }

        // 创建token
        String token = TokenUtil.createJWT(String.valueOf(userId), user.getUsername(), audience);
        // 将token放在响应头
        response.setHeader(TokenUtil.AUTH_HEADER_KEY, TokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        return new Result<>(200, "登录成功", token);
    }

    @PostMapping("/register")
    @JwtIgnore
    @ApiOperation(value = "注册", tags = AUTH_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    public Result<?> register(@RequestBody User user) {
        try {
            userService.register(user);
        } catch (MuseException e) {
            return Result.FAIL(e.getMessage());
        }
        return Result.SUCCESS();
    }
}
