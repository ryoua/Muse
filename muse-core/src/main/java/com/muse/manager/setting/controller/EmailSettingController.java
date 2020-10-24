package com.muse.manager.setting.controller;

import com.muse.manager.setting.model.EmailSetting;
import com.muse.manager.setting.service.EmailSettingService;
import com.muse.common.model.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@RestController
@RequestMapping("/setting/email")
public class EmailSettingController {
    private static final String EMAIL_SETTING_TAG = "邮箱设置";

    @Autowired
    EmailSettingService emailSettingService;

    @GetMapping("/")
    @ApiOperation(value = "获取全部邮箱设置", tags = EMAIL_SETTING_TAG, httpMethod = "GET")
    @ApiImplicitParams({})
    public Result<?> getAllEmailSetting() {
        return new Result<>(200, "ok", emailSettingService.getAllEmailSetting());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取邮箱设置", tags = EMAIL_SETTING_TAG, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "邮箱设置的id", required = true, dataType = "String"),
    })
    public Result<?> getEmailSettingById(@PathVariable("id") String id) {
        emailSettingService.getEmailSettingById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除邮箱设置", tags = EMAIL_SETTING_TAG, httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "邮箱设置的id", required = true, dataType = "String"),
    })
    public Result<?> deleteEmailSettingById(@PathVariable("id") String id) {
        emailSettingService.deleteEmailSettingById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新邮箱设置", tags = EMAIL_SETTING_TAG, httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "邮箱设置的id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "邮箱设置的参数", required = true, dataType = "EmailSetting"),

    })
    public Result<?> updateEmailSettingById(@PathVariable("id") String id, @RequestBody EmailSetting emailSetting) {
        emailSettingService.updateEmailSettingById(emailSetting);
        return Result.SUCCESS();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "新增邮箱设置", tags = EMAIL_SETTING_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "邮箱设置的参数", required = true, dataType = "EmailSetting"),
    })
    public Result<?> addEmailSetting(@RequestBody EmailSetting emailSetting) {
        emailSettingService.addEmailSetting(emailSetting);
        return Result.SUCCESS();
    }
}
