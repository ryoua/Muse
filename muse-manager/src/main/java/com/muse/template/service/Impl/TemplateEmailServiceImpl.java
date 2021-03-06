package com.muse.template.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muse.common.utils.Query;
import com.muse.template.dao.TemplateEmailDao;
import com.muse.template.entity.TemplateEmailEntity;
import com.muse.template.service.TemplateEmailService;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<Map<String, Object>> queryNames() {
        QueryWrapper queryWrapper = new QueryWrapper<>();;
        queryWrapper.select("id", "name");
        return this.baseMapper.selectMaps(queryWrapper);
    }

}
