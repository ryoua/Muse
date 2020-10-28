package com.muse.manager.template.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.template.mapper.ReceiverTemplateMapper;
import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.model.ReceiverTemplateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Service
public class ReceiverTemplateService {
    @Autowired
    ReceiverTemplateMapper receiverTemplateMapper;

    public PageInfo<ReceiverTemplate> getAllReceiverTemplate(int pageNo, int pageSize) {
        ReceiverTemplateExample example = new ReceiverTemplateExample();
        example.or().andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        example.setOrderByClause("id desc");
        PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(receiverTemplateMapper.selectByExample(example));
    }

    public void deleteReceiverTemplateById(long id) {
        receiverTemplateMapper.deleteByPrimaryKey(id);
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
}
