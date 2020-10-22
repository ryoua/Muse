package com.muse.service.Impl;

import com.google.gson.Gson;
import com.muse.mapper.MessageSendMapper;
import com.muse.model.MessageSendParam;
import com.muse.model.ReceiverTemplate;
import com.muse.service.MessageSendService;
import com.muse.threadLocal.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
@Service
public class MessageSendServiceImpl implements MessageSendService {
    @Autowired
    private MessageSendMapper messageSendMapper;
    @Autowired
    Gson gson;

    @Override
    public List<String> getAllMessageSendName() {
        Long userid = UserLocal.getUserId();
        return messageSendMapper.getAllMessageSendName(userid);
    }

    @Override
    public boolean getSendNameIsExist(String sendName) {
        Long userid = UserLocal.getUserId();
        String name = messageSendMapper.getMessageSendNameByName(sendName, userid);
        return name != null && !"".equals(name);
    }

    @Override
    public void sendMessage(Map<String, String> map) {
        String messageType = map.get(MessageSendParam.MESSAGE_TYPE);
        String paramStr = map.get(MessageSendParam.PARAM);
        String receiverStr = map.get(MessageSendParam.RECEIVER);

        int receiverType = (int) gson.fromJson(receiverStr, HashMap.class).get("type");

    }

}
