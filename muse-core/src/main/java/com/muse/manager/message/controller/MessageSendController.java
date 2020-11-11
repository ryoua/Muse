package com.muse.manager.message.controller;

import com.github.pagehelper.PageInfo;
import com.muse.common.exception.MuseException;
import com.muse.common.model.PageResult;
import com.muse.common.model.Result;
import com.muse.manager.message.model.MessageSend;
import com.muse.manager.message.model.MessageSendHistoryVo;
import com.muse.manager.message.model.MessageSendVo;
import com.muse.manager.message.service.MessageSendService;
import com.muse.manager.template.model.MessageTemplate;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/31
 **/
@RestController
@RequestMapping("/manager/message/send")
public class MessageSendController {
    private static final String MESSAGE_MANAGER_TAG = "消息管理";

    @Autowired
    private MessageSendService messageSendService;

    @GetMapping("/name/{messageName}")
    @ApiOperation(value = "查看消息名称是否存在", tags = MESSAGE_MANAGER_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageName", value = "消息名称", required = true, dataType = "String"),
    })
    public Result<?> getMessageName(@PathVariable("messageName") String messageName) {
        return messageSendService.getMessageNameIsExist(messageName) ? Result.SUCCESS(202) : Result.SUCCESS(200);
    }

    @PostMapping("/history/all")
    @ApiOperation(value = "查看全部历史消息发送", tags = MESSAGE_MANAGER_TAG, httpMethod = "POST")
    @ApiImplicitParams({
    })
    public PageResult<?> getAllMessageSendHistory(@RequestParam("pageNo") int pageNo,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @RequestBody MessageSend messageSend) {
        PageInfo<MessageSendHistoryVo> messageSendHistoryVoPageInfo = messageSendService.selectAllMessageSendHistory(pageNo, pageSize, messageSend);
        return new PageResult<>(200, "ok", messageSendHistoryVoPageInfo);
    }

    @GetMapping("/history/detail/{id}")
    @ApiOperation(value = "查看历史消息发送详情", tags = MESSAGE_MANAGER_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getMessageSendHistoryDetail(@PathVariable("id") String id) {
        return null;
    }

    @PostMapping("")
    @ApiOperation(value = "发送消息", tags = MESSAGE_MANAGER_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageName", value = "消息名称", required = true, dataType = "String"),
    })
    public Result<?> sendMessage(@RequestBody MessageSendVo messageSendVo) {
        try {
            messageSendService.sendMessage(messageSendVo);
        } catch (MuseException e) {
            e.printStackTrace();
        }
        return Result.SUCCESS();
    }
}
