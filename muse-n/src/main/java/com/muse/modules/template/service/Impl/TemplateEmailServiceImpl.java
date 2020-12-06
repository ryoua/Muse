package com.muse.modules.template.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muse.common.utils.PageUtils;
import com.muse.common.utils.Query;
import com.muse.modules.template.dao.TemplateEmailDao;
import com.muse.modules.template.entity.TemplateEmailEntity;
import com.muse.modules.template.service.TemplateEmailService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Service("templateEmailService")
public class TemplateEmailServiceImpl extends ServiceImpl<TemplateEmailDao, TemplateEmailEntity> implements TemplateEmailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TemplateEmailEntity> page = this.page(
                new Query<TemplateEmailEntity>().getPage(params),
                new QueryWrapper<TemplateEmailEntity>()
        );
        return new PageUtils(page);
    }

}
