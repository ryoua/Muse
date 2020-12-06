package com.muse.modules.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muse.common.utils.PageUtils;
import com.muse.modules.template.entity.TemplateEmailEntity;

import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
public interface TemplateEmailService extends IService<TemplateEmailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
