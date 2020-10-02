package com.muse.message.send.controller;

import com.muse.message.model.BusinessTemplate;
import com.muse.message.model.OperateTemplate;
import com.muse.message.send.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
@RestController
@RequestMapping("/api/message/")
public class MessageController extends BaseController {
    @ApiOperation(tags = TAG_TEMPLATE, value = "新增业务模板")
    @PostMapping("/add/businesstemplate")
    public Result<?> addBusinessMessage(@RequestBody BusinessTemplate businessTemplate) {
        int result = templateService.addBusinessTemplate(businessTemplate);
        return checkOperateResult(result);
    }

    @ApiOperation(tags = TAG_TEMPLATE, value = "新增营销模板")
    @PostMapping("/add/operatetemplate")
    public Result<?> addOperateTemplate(@RequestBody OperateTemplate operateTemplate) {
        int result = templateService.addOperateTemplate(operateTemplate);
        return checkOperateResult(result);
    }

}
