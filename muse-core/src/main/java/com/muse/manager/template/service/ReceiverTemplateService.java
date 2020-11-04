package com.muse.manager.template.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.template.mapper.ReceiverTemplateMapper;
import com.muse.manager.template.model.ParamTemplate;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.model.ReceiverTemplateExample;
import com.muse.manager.template.model.TemplateShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Service
public class ReceiverTemplateService {
    @Autowired
    ReceiverTemplateMapper receiverTemplateMapper;

    public List<TemplateShort> selectParamTemplateNameLike(String likeName) {
        ReceiverTemplate receiverTemplate = new ReceiverTemplate();
        receiverTemplate.setUid(UserLocal.getUserId());
        receiverTemplate.setName("%" + likeName + "%");
        return receiverTemplateMapper.selectReceiverTemplateNameLike(receiverTemplate);
    }

    public List<TemplateShort> getAllParamTemplateName() {
        return receiverTemplateMapper.selectTemplateShort(UserLocal.getUserId());
    }

    public PageInfo<ReceiverTemplate> getAllReceiverTemplate(int pageNo, int pageSize, ReceiverTemplate receiverTemplate) {
        ReceiverTemplateExample example = new ReceiverTemplateExample();
        ReceiverTemplateExample.Criteria criteria = example.or().andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        example.or(addSelectiveQueryParam(receiverTemplate, criteria));
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(receiverTemplateMapper.selectByExampleWithBLOBs(example));
    }

    public void deleteReceiverTemplateById(long id) {
        ReceiverTemplate receiverTemplate = new ReceiverTemplate();
        receiverTemplate.setId(id);
        receiverTemplate.setValid(false);
        receiverTemplateMapper.updateByPrimaryKeySelective(receiverTemplate);
    }

    public void deleteReceiverTemplateByIds(List<Long> ids) {
        ids.forEach(id -> {
            ReceiverTemplate receiverTemplate = new ReceiverTemplate();
            receiverTemplate.setId(id);
            receiverTemplate.setValid(false);
            receiverTemplateMapper.updateByPrimaryKeySelective(receiverTemplate);
        });
    }

    public void updateReceiverTemplate(ReceiverTemplate receiverTemplate) {
        long uid = UserLocal.getUserId();
        receiverTemplate.setUid(uid);
        receiverTemplateMapper.updateByPrimaryKey(receiverTemplate);
    }

    public void addReceiverTemplate(ReceiverTemplate receiverTemplate) {
        long uid = UserLocal.getUserId();
        receiverTemplate.setUid(uid);
        receiverTemplateMapper.insertSelective(receiverTemplate);
    }

    public ReceiverTemplateExample.Criteria addSelectiveQueryParam (ReceiverTemplate receiverTemplate, ReceiverTemplateExample.Criteria criteria) {
        if (!StringUtils.isEmpty(receiverTemplate.getName())) {
            criteria.andNameLike("%" + receiverTemplate.getName() + "%");
        }
        if (!StringUtils.isEmpty(receiverTemplate.getId())) {
            criteria.andIdEqualTo(receiverTemplate.getId());
        }
        if (!StringUtils.isEmpty(receiverTemplate.getReceivertype())) {
            criteria.andReceivertypeEqualTo(receiverTemplate.getReceivertype());
        }
        if (!StringUtils.isEmpty(receiverTemplate.getTemplatetype())) {
            criteria.andTemplatetypeEqualTo(receiverTemplate.getTemplatetype());
        }
        if (!StringUtils.isEmpty(receiverTemplate.getStatus())) {
            criteria.andStatusEqualTo(receiverTemplate.getStatus());
        }
        return criteria;
    }
}
