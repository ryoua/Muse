package com.muse.manager.message.service;

import com.google.gson.Gson;
import com.muse.common.exception.MuseException;
import com.muse.common.threadLocal.UserLocal;
import com.muse.dispatch.Dispatcher;
import com.muse.manager.message.mapper.MessageSendMapper;
import com.muse.manager.message.model.MessageSend;
import com.muse.manager.message.model.MessageSendHistoryVo;
import com.muse.manager.message.model.MessageSendVo;
import com.muse.manager.template.service.MessageTemplateService;
import com.muse.manager.template.service.ReceiverTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muse.manager.message.model.MessageSendExample;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.muse.manager.Constants.*;

/**
** @Author: RyouA
** @Date: 2020/10/31
**/
@Service
public class MessageSendService{
    @Autowired
    private MessageSendMapper messageSendMapper;
    @Autowired
    private MessageTemplateService messageTemplateService;
    @Autowired
    private ReceiverTemplateService receiverTemplateService;
    @Autowired
    private Dispatcher dispatcher;
    @Autowired
    Gson gson;

    public boolean getMessageNameIsExist(String messageName) {
        MessageSendExample example = new MessageSendExample();
        example.or().andNameEqualTo(messageName).andUidEqualTo(UserLocal.getUserId()).andValidEqualTo(true);
        return !messageSendMapper.selectByExample(example).isEmpty();
    }

    public List<MessageSendHistoryVo> selectAllMessageSendHistory() {
        return messageSendMapper.selectAllMessageSendHistory(UserLocal.getUserId());
    }

    /**
     * 消息发送
     * @param messageSendVo
     */
    @Transactional(rollbackFor = Exception.class)
    public void sendMessage(MessageSendVo messageSendVo) throws MuseException{
        // 参数校验
        paramCheck(messageSendVo);

        // VO => Bean的转换
        MessageSend messageSend = new MessageSend();
        messageSend.setName(messageSendVo.getMessageName());
        messageSend.setType(1);
        messageSend.setUid(UserLocal.getUserId());
        setMessageOfMessageSend(messageSend, messageSendVo);
        setReceiverOfMessageSend(messageSend, messageSendVo);

        // TODO: 暂时只入消息发送库
        // 入库
        messageSendMapper.insertSelective(messageSend);

        // 启动发送流程
        dispatcher.dispatch(messageSend);
    }

    private void paramCheck(MessageSendVo messageSendVo) throws MuseException {
        // TODO: 对参数进行校验
    }

    private boolean messageCheck(MessageSendVo messageSendVo) {
        // TODO: 对消息做校验
        return true;
    }

    private boolean receiverCheck(MessageSendVo messageSendVo) {
        // TODO: 对接收人群做校验
        return true;
    }

    public void setMessageOfMessageSend(MessageSend messageSend, MessageSendVo messageSendVo) {
        boolean messageIsTemplate = (boolean) messageSendVo.getMessage().get(CHOSE_TEMPLATE);
        messageSend.setMessageIsTemplate(messageIsTemplate);
        if (messageIsTemplate) {
            messageSend.setMessage((String) messageSendVo.getMessage().get(ID));
        } else {
            messageSend.setMessage((String) messageSendVo.getMessage().get(MESSAGE));
        }
        messageSend.setMessageType(messageSendVo.getMessageType());
    }

    public void setReceiverOfMessageSend(MessageSend messageSend, MessageSendVo messageSendVo) {
        boolean receiverIsTemplate = (boolean) messageSendVo.getMessage().get(CHOSE_TEMPLATE);
        messageSend.setReceiverIsTemplate(receiverIsTemplate);
        if (receiverIsTemplate) {
            messageSend.setReceiver((String) messageSendVo.getReceiver().get(ID));
        } else {
            messageSend.setReceiver((String) messageSendVo.getReceiver().get(RECEIVER));
        }
        messageSend.setReceiverType((Integer) messageSendVo.getReceiver().get(TYPE));
    }
}
