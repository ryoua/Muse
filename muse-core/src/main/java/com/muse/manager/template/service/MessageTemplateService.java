package com.muse.manager.template.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.template.mapper.MessageTemplateMapper;
import com.muse.manager.template.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Service
public class MessageTemplateService {
    @Autowired
    private MessageTemplateMapper messageTemplateMapper;

    public MessageTemplate getMessageTemplateById(Long id) {
        return messageTemplateMapper.selectByPrimaryKey(id);
    }

    public List<TemplateShort> selectMessageTemplateNameLike(String likeName) {
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setUid(UserLocal.getUserId());
        messageTemplate.setName("%" + likeName + "%");
        return messageTemplateMapper.selectMessageTemplateNameLike(messageTemplate);
    }

    public MessageTemplate selectMessageTemplateDetail(long id) {
        return messageTemplateMapper.selectByPrimaryKey(id);
    }

    public List<TemplateShort> getAllMessageTemplateName() {
        return messageTemplateMapper.selectTemplateShort(UserLocal.getUserId());
    }

    public PageInfo<MessageTemplate> getAllMessageTemplate(int pageNo, int pageSize, MessageTemplate messageTemplate) {
        MessageTemplateExample example = new MessageTemplateExample();
        MessageTemplateExample.Criteria criteria = example.or().andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        example.or(addSelectiveQueryParam(messageTemplate, criteria));
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(messageTemplateMapper.selectByExampleWithBLOBs(example));
    }

    public void deleteMessageTemplateById(long id) {
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setId(id);
        messageTemplate.setValid(false);
        messageTemplateMapper.updateByPrimaryKeySelective(messageTemplate);
    }

    public void deleteMessageTemplateByIds(List<Long> ids) {
        ids.forEach(id -> {
            MessageTemplate messageTemplate = new MessageTemplate();
            messageTemplate.setId(id);
            messageTemplate.setValid(false);
            messageTemplateMapper.updateByPrimaryKeySelective(messageTemplate);
        });
    }

    public void updateMessageTemplate(MessageTemplate messageTemplate) {
        long uid = UserLocal.getUserId();
        messageTemplate.setUid(uid);
        messageTemplateMapper.updateByPrimaryKey(messageTemplate);
    }

    public void addMessageTemplate(MessageTemplate messageTemplate) {
        long uid = UserLocal.getUserId();
        messageTemplate.setUid(uid);
        messageTemplateMapper.insertSelective(messageTemplate);
    }

    public MessageTemplateExample.Criteria addSelectiveQueryParam (MessageTemplate messageTemplate, MessageTemplateExample.Criteria criteria) {
        if (!StringUtils.isEmpty(messageTemplate.getName())) {
            criteria.andNameLike("%" + messageTemplate.getName() + "%");
        }
        if (!StringUtils.isEmpty(messageTemplate.getId())) {
            criteria.andIdEqualTo(messageTemplate.getId());
        }
        if (!StringUtils.isEmpty(messageTemplate.getType())) {
            criteria.andTypeEqualTo(messageTemplate.getType());
        }
        if (!StringUtils.isEmpty(messageTemplate.getStatus())) {
            criteria.andStatusEqualTo(messageTemplate.getStatus());
        }
        return criteria;
    }
}
