package com.muse.manager.template.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.template.mapper.ParamTemplateMapper;
import com.muse.manager.template.model.ParamTemplate;
import com.muse.manager.template.model.ParamTemplateExample;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.model.ReceiverTemplateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Service
public class ParamTemplateService {
    @Autowired
    private ParamTemplateMapper paramTemplateMapper;

    public PageInfo<ParamTemplate> getAllParamTemplate(int pageNo, int pageSize, ParamTemplate paramTemplate) {
        ParamTemplateExample example = new ParamTemplateExample();
        ParamTemplateExample.Criteria criteria = example.or().andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        example.or().andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(paramTemplateMapper.selectByExampleWithBLOBs(example));
    }

    public void deleteParamTemplateById(long id) {
        ParamTemplate paramTemplate = new ParamTemplate();
        paramTemplate.setId(id);
        paramTemplate.setValid(false);
        paramTemplateMapper.updateByPrimaryKeySelective(paramTemplate);
    }

    public void deleteParamTemplateByIds(List<Long> ids) {
        ids.forEach(id -> {
            ParamTemplate paramTemplate = new ParamTemplate();
            paramTemplate.setId(id);
            paramTemplate.setValid(false);
            paramTemplateMapper.updateByPrimaryKeySelective(paramTemplate);
        });
    }

    public void updateParamTemplate(ParamTemplate paramTemplate) {
        long uid = UserLocal.getUserId();
        paramTemplate.setUid(uid);
        paramTemplateMapper.updateByPrimaryKey(paramTemplate);
    }

    public void addParamTemplate(ParamTemplate paramTemplate) {
        long uid = UserLocal.getUserId();
        paramTemplate.setUid(uid);
        paramTemplateMapper.insertSelective(paramTemplate);
    }

    public ParamTemplateExample.Criteria addSelectiveQueryParam (ParamTemplate paramTemplate, ParamTemplateExample.Criteria criteria) {
        if (!StringUtils.isEmpty(paramTemplate.getName())) {
            criteria.andNameLike("%" + paramTemplate.getName() + "%");
        }
        if (!StringUtils.isEmpty(paramTemplate.getId())) {
            criteria.andIdEqualTo(paramTemplate.getId());
        }
        if (!StringUtils.isEmpty(paramTemplate.getTemplateType())) {
            criteria.andTemplateTypeEqualTo(paramTemplate.getTemplateType());
        }
        if (!StringUtils.isEmpty(paramTemplate.getStatus())) {
            criteria.andStatusEqualTo(paramTemplate.getStatus());
        }
        return criteria;
    }
}
