package com.muse.modules.template.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muse.common.utils.PageUtils;
import com.muse.common.utils.Query;
import com.muse.modules.template.dao.TemplateSmsDao;
import com.muse.modules.template.entity.TemplateSmsEntity;
import com.muse.modules.template.service.TemplateSmsService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Service("templateSmsService")
public class TemplateSmsServiceImpl extends ServiceImpl<TemplateSmsDao, TemplateSmsEntity> implements TemplateSmsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TemplateSmsEntity> page = this.page(
                new Query<TemplateSmsEntity>().getPage(params),
                new QueryWrapper<TemplateSmsEntity>()
        );

        return new PageUtils(page);
    }

}
