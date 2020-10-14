package com.muse.template.controller;

import com.muse.common.model.Result;
import com.muse.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@RequestMapping("/template/email")
public class TemplateController {
    @Autowired
    TemplateService templateService;

//    public Result<?> addEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
//        templateService.addTemplate(emailTemplate);
//        return Result.SUCCESS();
//    }
}
