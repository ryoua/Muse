package com.muse.message.send.controller;

import com.muse.message.model.BusinessTemplate;
import com.muse.message.model.OperateTemplate;
import com.muse.message.send.model.Result;
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
    @PostMapping("/add/businesstemplate")
    public Result<?> addBusinessMessage(@RequestBody BusinessTemplate businessTemplate) {
        int result = templateService.addBusinessTemplate(businessTemplate);
        return checkOperateResult(result);
    }

    @PostMapping("/add/operatetemplate")
    public Result<?> addOperateTemplate(@RequestBody OperateTemplate operateTemplate) {
        int result = templateService.addOperateTemplate(operateTemplate);
        return checkOperateResult(result);
    }
}
