package com.muse.manager.template.controller;

import com.github.pagehelper.PageInfo;
import com.muse.common.model.PageResult;
import com.muse.common.model.Result;
import com.muse.manager.template.model.ParamTemplate;
import com.muse.manager.template.service.ParamTemplateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@RestController
@RequestMapping("/manager/template/param")
public class ParamTemplateController {
    private static final String PARAM_TEMPLATE_TAG = "参数模板设置";

    @Autowired
    private ParamTemplateService paramTemplateService;

    @GetMapping("/getAllTemplateName")
    @ApiOperation(value = "获取全部参数模板名称", tags = PARAM_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getAllReceiverTemplate() {
        return new Result<>(200, "ok", paramTemplateService.getAllParamTemplateName());
    }

    @GetMapping("/getTemplateNameLike")
    @ApiOperation(value = "模糊查询参数模板名称", tags = PARAM_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
    })
    public Result<?> getParamTemplateNameLike(@RequestParam("name") String likeName) {
        return new Result<>(200, "ok", paramTemplateService.selectParamTemplateNameLike(likeName));
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "获取全部参数模板", tags = PARAM_TEMPLATE_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页的个数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "ReceiverTemplate", value = "参数模板", required = false, dataType = "ReceiverTemplate"),
    })
    public PageResult<?> getAllReceiverTemplate(@RequestParam("pageNo") int pageNo,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestBody ParamTemplate paramTemplate) {
        PageInfo<ParamTemplate> allParamTemplate = paramTemplateService.getAllParamTemplate(pageNo, pageSize, paramTemplate);
        return new PageResult<>(200, "ok", allParamTemplate);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除参数模板", tags = PARAM_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteReceiverTemplateById(@PathVariable("id") String id) {
        paramTemplateService.deleteParamTemplateById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @PostMapping("/delete/batch")
    @ApiOperation(value = "根据ID批量删除参数模板", tags = PARAM_TEMPLATE_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    })
    public Result<?> deleteReceiverTemplateByIds(@RequestBody List<Long> ids) {
        paramTemplateService.deleteParamTemplateByIds(ids);
        return Result.SUCCESS();
    }


    @PostMapping("/add")
    @ApiOperation(value = "新增接收人群模板", tags = PARAM_TEMPLATE_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ParamTemplate", value = "参数模板", required = true, dataType = "ParamTemplate"),
    })
    public Result<?> addReceiverTemplateById(@RequestBody ParamTemplate paramTemplate) {
        paramTemplateService.addParamTemplate(paramTemplate);
        return Result.SUCCESS();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新参数模板", tags = PARAM_TEMPLATE_TAG, httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ParamTemplate", value = "参数模板", required = true, dataType = "ParamTemplate"),
    })
    public Result<?> updateReceiverTemplateById(@RequestBody ParamTemplate paramTemplate) {
        paramTemplateService.updateParamTemplate(paramTemplate);
        return Result.SUCCESS();
    }
}
