package com.muse.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muse.template.entity.TemplatePeopleEntity;

import java.util.List;
import java.util.Map;

/**
 * 人群模板
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-08 19:58:38
 */
public interface TemplatePeopleService extends IService<TemplatePeopleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<Map<String, Object>> queryNames();
}

