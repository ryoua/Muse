package com.muse.modules.message.service.Impl;

import com.muse.common.utils.Query;
import com.muse.modules.message.dao.MessageSendDao;
import com.muse.modules.message.entity.MessageSendEntity;
import com.muse.modules.message.service.MessageSendService;
import com.muse.modules.message.vo.MessageSendVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("messageSendService")
public class MessageSendServiceImpl extends ServiceImpl<MessageSendDao, MessageSendEntity> implements MessageSendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MessageSendEntity> page = this.page(
                new Query<MessageSendEntity>().getPage(params),
                new QueryWrapper<MessageSendEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> queryNames() {
        QueryWrapper queryWrapper = new QueryWrapper<>();;
        queryWrapper.select("id", "name");
        return this.baseMapper.selectMaps(queryWrapper);
    }

    public void sendMessage(MessageSendVo messageSendVo) {
        MessageSendEntity messageSendEntity = new MessageSendEntity();
        messageSendEntity.setName(messageSendVo.getName());



    }


}