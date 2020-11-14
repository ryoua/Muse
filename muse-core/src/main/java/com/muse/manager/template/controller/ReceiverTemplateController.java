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

import java.util.List;

/**
 * 接收人群模板接口
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@RestController
@RequestMapping("api/manager/template/receiver")
public class ReceiverTemplateController {
    private static final String RECEIVER_TEMPLATE_TAG = "接收人群模板设置";

    @Autowired
    private ReceiverTemplateService receiverTemplateService;

    @GetMapping("/getAllTemplateName")
    @ApiOperation(value = "获取全部参数模板名称", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getAllReceiverTemplate() {
        return new Result<>(200, "ok", receiverTemplateService.getAllParamTemplateName());
    }

    @GetMapping("/getTemplateNameLike")
    @ApiOperation(value = "模糊查询参数模板名称", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getParamTemplateNameLike(@RequestParam("name") String likeName) {
        return new Result<>(200, "ok", receiverTemplateService.selectParamTemplateNameLike(likeName));
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "获取全部接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页的个数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "ReceiverTemplate", value = "接收人群模板", required = false, dataType = "ReceiverTemplate"),
    })
    public PageResult<?> getAllReceiverTemplate(@RequestParam("pageNo") int pageNo,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestBody ReceiverTemplate receiverTemplate) {
        PageInfo<ReceiverTemplate> allReceiverTemplate = receiverTemplateService.getAllReceiverTemplate(pageNo, pageSize, receiverTemplate);
        return new PageResult<>(200, "ok", allReceiverTemplate);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteReceiverTemplateById(@PathVariable("id") String id) {
        receiverTemplateService.deleteReceiverTemplateById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @PostMapping("/delete/batch")
    @ApiOperation(value = "根据ID批量删除接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteReceiverTemplateByIds(@RequestBody List<Long> ids) {
        receiverTemplateService.deleteReceiverTemplateByIds(ids);
        return Result.SUCCESS();
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ReceiverTemplate", value = "接收人群模板", required = true, dataType = "ReceiverTemplate"),
    })
    public Result<?> addReceiverTemplateById(@RequestBody ReceiverTemplate receiverTemplate) {
        receiverTemplateService.addReceiverTemplate(receiverTemplate);
        return Result.SUCCESS();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新接收人群模板", tags = RECEIVER_TEMPLATE_TAG, httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ReceiverTemplate", value = "接收人群模板", required = true, dataType = "ReceiverTemplate"),
    })
    public Result<?> updateReceiverTemplateById(@RequestBody ReceiverTemplate receiverTemplate) {
        receiverTemplateService.updateReceiverTemplate(receiverTemplate);
        return Result.SUCCESS();
    }
}
