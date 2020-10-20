package com.muse.message.controller;

import com.muse.message.model.vo.MessageSendVo;
import com.muse.message.service.MessageService;
import com.muse.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/17
 **/
@RequestMapping("/manager/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Result<?> send(@RequestBody MessageSendVo messageSendVo) {
        return Result.SUCCESS();
    }
}
