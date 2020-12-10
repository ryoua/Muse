package com.muse.modules.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muse.modules.message.entity.MessageSendEntity;

import java.util.List;
import java.util.Map;

/**
 * 消息发送
 *
 */
public interface MessageSendService extends IService<MessageSendEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<Map<String, Object>> queryNames();
}

