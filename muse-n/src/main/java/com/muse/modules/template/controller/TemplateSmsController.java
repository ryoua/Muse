package com.muse.modules.template.controller;

import com.muse.common.utils.PageUtils;
import com.muse.common.utils.R;
import com.muse.modules.template.entity.TemplateSmsEntity;
import com.muse.modules.template.service.TemplateSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@RestController
@RequestMapping("/template/sms")
public class TemplateSmsController {
    @Autowired
    private TemplateSmsService templateSmsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = templateSmsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TemplateSmsEntity templateSms = templateSmsService.getById(id);

        return R.ok().put("templateSms", templateSms);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TemplateSmsEntity templateSms){
        templateSmsService.save(templateSms);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TemplateSmsEntity templateSms){
        templateSmsService.updateById(templateSms);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        templateSmsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

