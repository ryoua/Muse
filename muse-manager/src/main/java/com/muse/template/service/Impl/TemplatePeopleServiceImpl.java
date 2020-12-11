package com.muse.template.service.Impl;

import com.muse.common.utils.Query;
import com.muse.template.dao.TemplatePeopleDao;
import com.muse.template.entity.TemplatePeopleEntity;
import com.muse.template.service.TemplatePeopleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("templatePeopleService")
public class TemplatePeopleServiceImpl extends ServiceImpl<TemplatePeopleDao, TemplatePeopleEntity> implements TemplatePeopleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TemplatePeopleEntity> page = this.page(
                new Query<TemplatePeopleEntity>().getPage(params),
                new QueryWrapper<TemplatePeopleEntity>()
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
