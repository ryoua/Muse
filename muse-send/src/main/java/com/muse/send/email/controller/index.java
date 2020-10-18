package com.muse.send.email.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@RestController
@RequestMapping("/api/send/")
public class index {
    @GetMapping("test")
    public int test() {
        return 3;
    }
}
