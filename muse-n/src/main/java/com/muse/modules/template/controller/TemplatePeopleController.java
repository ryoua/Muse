package com.muse.modules.template.controller;

import java.util.Arrays;
import java.util.Map;

import com.muse.common.local.UserLocal;
import com.muse.common.utils.R;
import com.muse.modules.template.entity.TemplatePeopleEntity;
import com.muse.modules.template.service.TemplatePeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 人群模板
 *
 */
@RestController
@RequestMapping("/template/people")
public class TemplatePeopleController {
    @Autowired
    private TemplatePeopleService templatePeopleService;

    @RequestMapping("/list/name")
    public R listName() {
        return R.ok().put("data", templatePeopleService.queryNames());
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = templatePeopleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TemplatePeopleEntity templatePeople = templatePeopleService.getById(id);

        return R.ok().put("templatePeople", templatePeople);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TemplatePeopleEntity templatePeople){
        templatePeople.setUserId(UserLocal.getUserId());
        templatePeopleService.save(templatePeople);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TemplatePeopleEntity templatePeople){
        templatePeopleService.updateById(templatePeople);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        templatePeopleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
