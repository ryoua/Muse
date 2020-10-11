package com.muse.manager.setting.controller;

import com.muse.common.model.Result;
import com.muse.manager.setting.model.EmailSetting;
import com.muse.manager.setting.service.EmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@RestController
@RequestMapping("/setting/email")
public class EmailSettingController {
    @Autowired
    EmailSettingService emailSettingService;

    @GetMapping("/{id}")
    public Result<EmailSetting> getEmailSettingById(@PathVariable("id") long id) {
        EmailSetting emailSetting = emailSettingService.getEmailSettingById(id);
        return new Result<>(200, "OK", emailSetting);
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteEmailSettingById(@PathVariable("id") long id) {
        emailSettingService.deleteEmailSetting(id);
        return Result.SUCCESS();
    }

    @PutMapping("")
    public Result<?> updateEmailSetting(@RequestBody EmailSetting emailSetting) {
        emailSettingService.updateEmailSetting(emailSetting);
        return Result.SUCCESS();
    }

//    @GetMapping("/")
//    public Result<List<EmailSetting>> getAllEmailSetting() {
//        List<EmailSetting> allEmailSettings = emailSettingService.getAllEmailSetting();
//        return new Result<>(200, "OK", allEmailSettings);
//    }

    @PostMapping("")
    public Result<?> addEmailSetting(@RequestBody EmailSetting emailSetting) {
        emailSettingService.addEmailSetting(emailSetting);
        return Result.SUCCESS();
    }
}
