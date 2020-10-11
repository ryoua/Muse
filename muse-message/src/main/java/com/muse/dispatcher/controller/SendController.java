package com.muse.dispatcher.controller;

import com.muse.common.model.Result;
import com.muse.dispatcher.model.SendParam;
import com.muse.dispatcher.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一发送接口
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@RequestMapping("/send/message")
public class SendController {
    @Autowired
    ISendService sendService;

    @PostMapping("/")
    public Result sendMessage(@RequestBody SendParam sendParam) {
        sendService.send(sendParam);
        return Result.SUCCESS();
    }
}
