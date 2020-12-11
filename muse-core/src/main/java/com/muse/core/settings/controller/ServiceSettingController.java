package com.muse.core.settings.controller;

import com.muse.common.model.Result;
import com.muse.core.settings.model.ServiceSetting;
import com.muse.core.settings.service.ServiceSettingService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/2
 **/
@RestController
@RequestMapping("/api/settings")
public class ServiceSettingController {
    @Autowired
    private ServiceSettingService serviceSettingService;

    private static final String SERVICE_SETTING_TAG = "服务对接设置";

    @GetMapping("/email/{factory}")
    @ApiOperation(value = "获取邮箱设置", tags = SERVICE_SETTING_TAG, httpMethod = "GET")
    @ApiImplicitParams({})
    public Result<?> getEmailSetting(@PathVariable("factory") String factory) {
        return new Result<>(200, "ok", serviceSettingService.getEmailSettingByFactory(factory));
    }

    @GetMapping("/sms/{factory}")
    @ApiOperation(value = "获取短信设置", tags = SERVICE_SETTING_TAG, httpMethod = "GET")
    @ApiImplicitParams({})
    public Result<?> getSmsSetting(@PathVariable("factory") String factory) {
        return new Result<>(200, "ok", serviceSettingService.getSmsSettingByFactory(factory));
    }

//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "删除邮箱设置", tags = SERVICE_SETTING_TAG, httpMethod = "DELETE")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "邮箱设置的id", required = true, dataType = "String"),
//    })
//    public Result<?> deleteEmailSettingById(@PathVariable("id") String id) {
//        emailSettingService.deleteEmailSetting(Long.parseLong(id));
//        return Result.SUCCESS();
//    }
//
//    @PutMapping("/{id}")
//    @ApiOperation(value = "更新邮箱设置", tags = SERVICE_SETTING_TAG, httpMethod = "PUT")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "邮箱设置的id", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "id", value = "邮箱设置的参数", required = true, dataType = "EmailSetting"),
//
//    })
//    public Result<?> updateEmailSettingById(@PathVariable("id") String id, @RequestBody EmailSetting emailSetting) {
//        emailSetting.setId(Long.parseLong(id));
//        emailSettingService.updateEmailSetting(emailSetting);
//        return Result.SUCCESS();
//    }
//

    @PostMapping("/email")
    @ApiOperation(value = "新增邮箱设置", tags = SERVICE_SETTING_TAG, httpMethod = "POST")
    @ApiImplicitParams({
    })
    public Result<?> addEmailSetting(@RequestBody ServiceSetting serviceSetting) {
        serviceSettingService.addEmailSetting(serviceSetting);
        return Result.SUCCESS();
    }

    @PostMapping("/sms")
    @ApiOperation(value = "新增短信设置", tags = SERVICE_SETTING_TAG, httpMethod = "POST")
    @ApiImplicitParams({
    })
    public Result<?> addSmsSetting(@RequestBody ServiceSetting serviceSetting) {
        serviceSettingService.addSmsSetting(serviceSetting);
        return Result.SUCCESS();
    }
}
