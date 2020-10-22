package com.muse.controller;

import com.muse.model.MessageSendParam;
import com.muse.model.Result;
import com.muse.service.MessageSendService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
@RestController
@RequestMapping("/api/manager/message")
public class MessageSendController {
    @Autowired
    private MessageSendService messageSendService;

    private static final String MESSAGE_SEND = "消息发送";

    @ApiOperation(value = "获取当前用户的所有历史消息发送名", tags = MESSAGE_SEND, httpMethod = "GET")
    @ApiImplicitParams({})
    @GetMapping("/sendName")
    public Result<?> getAllMessageSendName() {
        List<String> allMessageSendName = messageSendService.getAllMessageSendName();
        return new Result<>(200, "ok", allMessageSendName);
    }

    @ApiOperation(value = "查看当前消息名是否已存在", tags = MESSAGE_SEND, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "消息名", required = true, dataType = "String"),
    })
    @GetMapping("/sendName/{name}")
    public Result<?> getSendNameIsExist(@PathVariable("name") String sendName) {
        boolean isExist = messageSendService.getSendNameIsExist(sendName);
        return new Result<>(200, "ok", isExist);
    }

    @ApiOperation(value = "消息发送", tags = MESSAGE_SEND, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageType", value = "消息类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "messageName", value = "消息名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "param", value = "消息参数(JSON)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "receiver", value = "接受者(JSON)", required = true, dataType = "String"),
    })
    @PostMapping("/send")
    public Result<?> messageSend(@RequestBody Map<String, String> param) {
        if (param.get(MessageSendParam.RECEIVER) == null || param.get(MessageSendParam.PARAM) == null) {
            return Result.FAIL();
        }
        messageSendService.sendMessage(param);
        return Result.SUCCESS();
    }
}
