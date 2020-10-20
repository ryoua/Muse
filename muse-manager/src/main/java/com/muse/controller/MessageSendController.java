package com.muse.controller;

import com.muse.model.MessageSendParam;
import com.muse.model.Result;
import com.muse.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
@RestController
@RequestMapping("/manager/message")
public class MessageSendController {
    @Autowired
    private MessageSendService messageSendService;

    @GetMapping("/sendName")
    public Result<?> getAllMessageSendName() {
        List<String> allMessageSendName = messageSendService.getAllMessageSendName();
        return new Result<>(200, "ok", allMessageSendName);
    }

    @PostMapping("/send")
    public Result<?> messageSend(@RequestBody Map<String, String> param) {
        if (param.get(MessageSendParam.RECEIVER) == null || param.get(MessageSendParam.PARAM) == null) {
            return Result.FAIL();
        }
        messageSendService.sendMessage(param);
        return Result.SUCCESS();
    }
}
