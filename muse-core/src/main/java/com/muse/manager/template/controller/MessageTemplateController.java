package com.muse.manager.template.controller;

import com.github.pagehelper.PageInfo;
import com.muse.common.model.PageResult;
import com.muse.common.model.Result;
import com.muse.manager.template.model.MessageTemplate;
import com.muse.manager.template.service.MessageTemplateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息模板接口
 * * @Author: RyouA
 * * @Date: 2020/11/5
 **/
@RestController
@RequestMapping("api/manager/template/message")
public class MessageTemplateController {
    private static final String MESSAGE_TEMPLATE_TAG = "消息模板设置";

    @Autowired
    private MessageTemplateService messageTemplateService;

    @GetMapping("/getAllTemplateName/{messageType}")
    @ApiOperation(value = "获取全部消息模板名称", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getAllMessageTemplate(@PathVariable("messageType") Integer messageType) {
        return new Result<>(200, "ok", messageTemplateService.getAllMessageTemplateName(messageType));
    }

    @GetMapping("/search")
    @ApiOperation(value = "模糊查询", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getAllMessageTemplate(@RequestParam("messageType") Integer messageType, @RequestParam("search") String messageName) {
        return new Result<>(200, "ok", messageTemplateService.searchMessageTemplateName(messageType, messageName));
    }


    @GetMapping("/getTemplateNameLike")
    @ApiOperation(value = "模糊查询消息模板名称", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getMessageTemplateNameLike(@RequestParam("name") String likeName) {
        return new Result<>(200, "ok", messageTemplateService.selectMessageTemplateNameLike(likeName));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查看消息模板详情", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    public Result<?> getMessageTemplateDetail(@PathVariable("id") long id) {
        return new Result<>(200, "ok", messageTemplateService.selectMessageTemplateDetail(id));
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "获取全部消息模板", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页的个数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "ReceiverTemplate", value = "参数模板", required = false, dataType = "ReceiverTemplate"),
    })
    public PageResult<?> getAllMessageTemplate(@RequestParam("pageNo") int pageNo,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestBody MessageTemplate messageTemplate) {
        PageInfo<MessageTemplate> allParamTemplate = messageTemplateService.getAllMessageTemplate(pageNo, pageSize, messageTemplate);
        return new PageResult<>(200, "ok", allParamTemplate);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除消息模板", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteMessageTemplateById(@PathVariable("id") String id) {
        messageTemplateService.deleteMessageTemplateById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @PostMapping("/delete/batch")
    @ApiOperation(value = "根据ID批量删除消息模板", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteMessageTemplateByIds(@RequestBody List<Long> ids) {
        messageTemplateService.deleteMessageTemplateByIds(ids);
        return Result.SUCCESS();
    }


    @PostMapping("/add")
    @ApiOperation(value = "新增消息模板", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ParamTemplate", value = "参数模板", required = true, dataType = "ParamTemplate"),
    })
    public Result<?> addMessageTemplateById(@RequestBody MessageTemplate messageTemplate) {
        messageTemplateService.addMessageTemplate(messageTemplate);
        return Result.SUCCESS();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新消息模板", tags = MESSAGE_TEMPLATE_TAG, httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ParamTemplate", value = "参数模板", required = true, dataType = "ParamTemplate"),
    })
    public Result<?> updateMessageTemplateById(@RequestBody MessageTemplate messageTemplate) {
        messageTemplateService.updateMessageTemplate(messageTemplate);
        return Result.SUCCESS();
    }
}
