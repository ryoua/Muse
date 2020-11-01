package com.muse.manager.message.service;

import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.message.mapper.MessageSendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muse.manager.message.model.MessageSendExample;
/**
** @Author: RyouA
** @Date: 2020/10/31
**/
@Service
public class MessageSendService{
    @Autowired
    private MessageSendMapper messageSendMapper;

    public boolean getMessageNameIsExist(String messageName) {
        MessageSendExample example = new MessageSendExample();
        example.or().andNameEqualTo(messageName).andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        return !messageSendMapper.selectByExample(example).isEmpty();
    }
}
