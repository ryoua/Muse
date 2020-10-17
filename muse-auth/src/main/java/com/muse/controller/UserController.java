package com.muse.controller;

import com.muse.config.JwtIgnore;
import com.muse.model.Audience;
import com.muse.model.Result;
import com.muse.model.User;
import com.muse.service.UserService;
import com.muse.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Slf4j
@RestController
@RequestMapping("/auth/")
public class UserController {
    @Autowired
    private Audience audience;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @JwtIgnore
    public Result<?> login(HttpServletResponse response, @RequestBody User user) throws JSONException {
        String userId = userService.login(user);
        if (userId == null) {
            return Result.FAIL("账号或密码错误");
        }

        // 创建token
        String token = TokenUtil.createJWT(userId, user.getUsername(), audience);
        log.info("=============登录成功,token={}:================", token);

        // 将token放在响应头
        response.setHeader(TokenUtil.AUTH_HEADER_KEY, TokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", token);
        return new Result<>(200, "登录成功", jsonObject);
    }

    @PostMapping("/register")
    public Result<?> register() {
        return Result.SUCCESS();
    }
}
