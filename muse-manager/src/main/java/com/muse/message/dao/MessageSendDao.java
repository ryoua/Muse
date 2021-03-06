package com.muse.message.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muse.message.entity.MessageSendEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息发送
 *
 */
@Mapper
public interface MessageSendDao extends BaseMapper<MessageSendEntity> {

}
