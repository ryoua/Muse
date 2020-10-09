package com.muse.message.dispatcher.controller;

import com.muse.common.model.Result;
import com.muse.message.dispatcher.model.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@RequestMapping("/send/message")
public class SendController {
    @Autowired
    MessageDisPatcher messageDisPatcher;

    @PostMapping("/")
    public Result sendMessage(@RequestBody SendParam sendParam) {
        messageDisPatcher.dispatch(sendParam);
        return Result.SUCCESS();
    }
}
