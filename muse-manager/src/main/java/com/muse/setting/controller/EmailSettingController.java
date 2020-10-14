package com.muse.setting.controller;

import com.muse.common.model.Result;
import com.muse.common.util.ControllerUtil;
import com.muse.setting.model.EmailSetting;
import com.muse.setting.service.EmailSettingService;
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
    public Result<?> getEmailSettingById(@PathVariable("id") long id) {
        EmailSetting emailSetting = emailSettingService.getEmailSettingById(id);
        if (emailSetting == null) {
            return new Result<>(500, "error", "邮箱设置不存在");
        } else {
            return new Result<>(200, "OK", emailSetting);
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteEmailSettingById(@PathVariable("id") long id) {
        return ControllerUtil.checkResult(emailSettingService.deleteEmailSetting(id));
    }

    @PutMapping("/{id}")
    public Result<?> updateEmailSetting(@RequestBody EmailSetting emailSetting, @PathVariable("id") long id) {
        return ControllerUtil.checkResult(emailSettingService.updateEmailSetting(emailSetting, id));
    }

//    @GetMapping("/")
//    public Result<List<EmailSetting>> getAllEmailSetting() {
//        List<EmailSetting> allEmailSettings = emailSettingService.getAllEmailSetting();
//        return new Result<>(200, "OK", allEmailSettings);
//    }

    @PostMapping("")
    public Result<?> addEmailSetting(@RequestBody EmailSetting emailSetting) {
        return ControllerUtil.checkResult(emailSettingService.addEmailSetting(emailSetting));
    }
}
