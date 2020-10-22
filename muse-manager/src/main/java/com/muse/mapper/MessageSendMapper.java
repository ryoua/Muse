package com.muse.mapper;

import com.muse.model.MessageSend;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
@Mapper
public interface MessageSendMapper {
    @Select(value = "select message_name from m_message_send where uid = #{id} and valid = 1")
    List<String> getAllMessageSendName(Long id);

    @Select(value = "select message_name from m_message_send where message_name = #{name} and uid = #{id} and valid = 1")
    String getMessageSendNameByName(String name, Long id);

    @Select(value = "select " +
            "id, " +
            "uid, " +
            "message_name, " +
            "message_type, " +
            "param_template_id, " +
            "param_str, " +
            "receiver_template_id, " +
            "receivers, " +
            "receiver_sql, " +
            "receiver_file_url, " +
            "update_time, " +
            "create_time " +
            "from m_message_send where id = #{id} and uid = #{uid} and valid = 1")
    MessageSend getMessageSendById(@Param("id") Long id, @Param("uid") Long uid);

    @Update(value = "update m_message_send set valid = 0 where id = #{id} and uid = #{uid} ")
    int deleteMessageSendById(@Param("id") Long id, @Param("uid") Long uid);

    @Insert("insert into m_message_send " +
            "       (uid, message_name, message_type, param_template_id, param_str, receiver_template_id, receivers, receiver_sql, receiver_file_url) " +
            "VALUES (#{uid}, #{messageName}, #{messageType}, #{paramTemplateId}, #{paramStr}, #{receiverTemplateId}, #{receivers}, #{receiverSql})")
    int addMessageSend(MessageSend messageSend);
}
