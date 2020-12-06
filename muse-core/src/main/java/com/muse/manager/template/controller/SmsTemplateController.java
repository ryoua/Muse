package com.muse.manager.template.controller;

import com.muse.common.model.Result;
import com.muse.manager.template.model.SmsTemplate;
import com.muse.manager.template.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@RestController
@RequestMapping("/api/template/sms")
public class SmsTemplateController {
    @Autowired
    private SmsTemplateService smsTemplateService;

    @GetMapping("/findAll")
    public Result findAllSmsTemplate(@RequestParam("page") int page,
                                     @RequestParam("size") int size) {
        return Result.SUCCESS(smsTemplateService.findAllSmsTemplate(page, size));
    }

    @PostMapping("/save")
    public Result saveSmsTemplate(@RequestBody SmsTemplate smsTemplate) {
        smsTemplateService.saveSmsTemplate(smsTemplate);
        return Result.SUCCESS();
    }
}
