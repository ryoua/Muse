package com.muse.modules.template.controller;

import com.muse.common.local.UserLocal;
import com.muse.common.utils.PageUtils;
import com.muse.common.utils.R;
import com.muse.modules.template.entity.TemplateEmailEntity;
import com.muse.modules.template.service.TemplateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@RestController
@RequestMapping("/template/email")
public class TemplateEmailController {
    @Autowired
    private TemplateEmailService templateEmailService;

    @RequestMapping("/list/name")
    public R listName() {
        return R.ok().put("data", templateEmailService.queryNames());
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = templateEmailService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TemplateEmailEntity templateEmail = templateEmailService.getById(id);

        return R.ok().put("templateEmail", templateEmail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TemplateEmailEntity templateEmail){
        templateEmail.setUserId(UserLocal.getUserId());
        templateEmailService.save(templateEmail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TemplateEmailEntity templateEmail){
        templateEmail.setUserId(UserLocal.getUserId());
        templateEmailService.updateById(templateEmail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        templateEmailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

