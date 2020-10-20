package com.muse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
@Mapper
public interface MessageSendMapper {
    @Select(value = " select message_name from m_message_send where uid = #{id} ")
    List<String> getAllMessageSendName(Long id);
}
