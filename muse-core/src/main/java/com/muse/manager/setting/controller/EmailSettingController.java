package com.muse.manager.setting.controller;

import com.muse.manager.setting.model.EmailSetting;
import com.muse.manager.setting.service.EmailSettingService;
import com.muse.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@RestController
@RequestMapping("/setting/email")
public class EmailSettingController {
    @Autowired
    EmailSettingService emailSettingService;

    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable("id") @NotNull String id) {
        emailSettingService.deleteById(Long.parseLong(id));
        return Result.SUCCESS();
    }

    @PutMapping("/{id}")
    public Result<?> updateById(@PathVariable("id") @NotNull String id, @RequestBody EmailSetting emailSetting) {
        emailSettingService.updateById(emailSetting);
        return Result.SUCCESS();
    }

//    @PostMapping("")
//    public Result<?> insert(@RequestBody EmailSetting emailSetting) {
//        emailSettingService.
//    }
}
