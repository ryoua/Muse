package com.muse.message.send.controller;

import com.muse.message.send.model.Result;
import com.muse.message.send.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
public class BaseController {
    protected static final String TAG_TEMPLATE = "模板相关接口";

    @Autowired
    TemplateService templateService;

    public Result<?> checkOperateResult(int result) {
        if (result == 1) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
}
