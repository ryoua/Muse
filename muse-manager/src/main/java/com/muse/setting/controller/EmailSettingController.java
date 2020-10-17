package com.muse.setting.controller;

import com.muse.model.Result;
import com.muse.setting.model.EmailSetting;
import com.muse.setting.service.EmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@RestController
@RequestMapping("/api/settings/email")
public class EmailSettingController {
    @Autowired
    EmailSettingService emailSettingService;

    @PostMapping("/")
    public Result<?> addEmailSetting(@RequestBody EmailSetting emailSetting) {
        emailSettingService.addEmailSetting(emailSetting);
        return Result.SUCCESS();
    }

    @GetMapping("/")
    public Result<?> getAllEmailSetting() {
        return new Result<>(200, "ok", emailSettingService.getAllEmailSetting());
    }
}
