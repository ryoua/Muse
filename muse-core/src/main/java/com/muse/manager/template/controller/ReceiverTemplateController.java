package com.muse.manager.template.controller;

import com.github.pagehelper.PageInfo;
import com.muse.common.model.PageResult;
import com.muse.common.model.Result;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.service.ReceiverTemplateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@RestController
@RequestMapping("/manager/template/receiver")
public class ReceiverTemplateController {
    private static final String RECEIVER_TEMPLATE_TAG = "接收人群模板设置";

    @Autowired
    private ReceiverTemplateService receiverTemplateService;

    @GetMapping("")
    @ApiOperation(value = "获取全部接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页的个数", required = true, dataType = "int")
    })
    public PageResult<?> getAllReceiverTemplate(@RequestParam("pageNo") int pageNo,
                                                @RequestParam("pageSize") int pageSize) {
        PageInfo<ReceiverTemplate> allReceiverTemplate = receiverTemplateService.getAllReceiverTemplate(pageNo, pageSize);
        return new PageResult<>(200, "ok", allReceiverTemplate);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteReceiverTemplateById(@PathVariable("id") String id) {
        receiverTemplateService.deleteReceiverTemplateById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @PostMapping("")
    @ApiOperation(value = "新增接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ReceiverTemplate", value = "接收人群模板", required = true, dataType = "ReceiverTemplate"),
    })
    public Result<?> addReceiverTemplateById(@RequestBody ReceiverTemplate receiverTemplate) {
        receiverTemplateService.addReceiverTemplate(receiverTemplate);
        return Result.SUCCESS();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ReceiverTemplate", value = "接收人群模板", required = true, dataType = "ReceiverTemplate"),
    })
    public Result<?> updateReceiverTemplateById(@RequestBody ReceiverTemplate receiverTemplate) {
        receiverTemplateService.updateReceiverTemplate(receiverTemplate);
        return Result.SUCCESS();
    }
}
