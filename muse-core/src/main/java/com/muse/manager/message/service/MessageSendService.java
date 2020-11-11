package com.muse.manager.message.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.muse.common.exception.MuseException;
import com.muse.common.threadLocal.UserLocal;
import com.muse.dispatch.Dispatcher;
import com.muse.manager.message.mapper.MessageSendMapper;
import com.muse.manager.message.model.MessageSend;
import com.muse.manager.message.model.MessageSendHistoryVo;
import com.muse.manager.message.model.MessageSendVo;
import com.muse.manager.template.model.MessageTemplate;
import com.muse.manager.template.model.MessageTemplateExample;
import com.muse.manager.template.service.MessageTemplateService;
import com.muse.manager.template.service.ReceiverTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muse.manager.message.model.MessageSendExample;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.muse.manager.Constants.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/31
 **/
@Service
public class MessageSendService {
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

    public PageInfo<MessageSendHistoryVo> selectAllMessageSendHistory(int pageNo, int pageSize, MessageSend messageSend) {
        if (!StringUtils.isEmpty(messageSend.getName())) {
            messageSend.setName("%" + messageSend.getName() + "%");
        }
        messageSend.setUid(UserLocal.getUserId());
        PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(messageSendMapper.selectAllMessageSendHistory(messageSend));
    }

    /**
     * 消息发送
     * @param messageSendVo
     */
    @Transactional(rollbackFor = Exception.class)
    public void sendMessage(MessageSendVo messageSendVo) throws MuseException {
        // 参数校验
        paramCheck(messageSendVo);

        // VO => Bean的转换
        MessageSend messageSend = new MessageSend();
        messageSend.setName(messageSendVo.getMessageName());
        messageSend.setType(1);
        messageSend.setUid(UserLocal.getUserId());
        setMessageOfMessageSend(messageSend, messageSendVo);
        setReceiverOfMessageSend(messageSend, messageSendVo);

        // 入库
        messageSendMapper.insertSelective(messageSend);

        // 启动发送流程
        dispatcher.dispatch(messageSend);
    }

    private void paramCheck(MessageSendVo messageSendVo) throws MuseException {
        // TODO: 对参数进行校验
        messageCheck(messageSendVo);
        receiverCheck(messageSendVo);
    }

    private boolean messageCheck(MessageSendVo messageSendVo) throws MuseException{
        // TODO: 对消息做校验
        return true;
    }

    private boolean receiverCheck(MessageSendVo messageSendVo) throws MuseException{
        // TODO: 对接收人群做校验
        return true;
    }

    /**
     * 设置消息发送的消息体
     * @param messageSend
     * @param messageSendVo
     */
    public void setMessageOfMessageSend(MessageSend messageSend, MessageSendVo messageSendVo) {
        boolean messageIsTemplate = (boolean) messageSendVo.getMessage().get(CHOSE_TEMPLATE);
        messageSend.setMessageIsTemplate(messageIsTemplate);
        messageSend.setMessage((String.valueOf(messageSendVo.getMessage().get(MESSAGE))));
        messageSend.setMessageType(messageSendVo.getMessageType());
    }

    /**
     * 设置消息发送的接收人群
     * @param messageSend
     * @param messageSendVo
     */
    public void setReceiverOfMessageSend(MessageSend messageSend, MessageSendVo messageSendVo) {
        boolean receiverIsTemplate = (boolean) messageSendVo.getMessage().get(CHOSE_TEMPLATE);
        messageSend.setReceiverIsTemplate(receiverIsTemplate);
        messageSend.setReceiver(String.valueOf(messageSendVo.getReceiver().get(RECEIVER)));
        messageSend.setReceiverType((Integer) messageSendVo.getReceiver().get(TYPE));
    }

    public MessageSendExample.Criteria addSelectiveQueryParam (MessageSend messageSend, MessageSendExample.Criteria criteria) {
        if (!StringUtils.isEmpty((messageSend.getName()))) {
            criteria.andNameLike("%" + messageSend.getName() + "%");
        }
        if (!StringUtils.isEmpty(messageSend.getId())) {
            criteria.andIdEqualTo(messageSend.getId());
        }
        if (!StringUtils.isEmpty(messageSend.getType())) {
            criteria.andTypeEqualTo(messageSend.getType());
        }
        if (!StringUtils.isEmpty(messageSend.getStep())) {
            criteria.andStepEqualTo(messageSend.getStep());
        }
        return criteria;
    }
}
