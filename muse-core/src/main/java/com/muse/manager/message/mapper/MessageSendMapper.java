package com.muse.manager.message.mapper;

import com.muse.manager.message.model.MessageSend;
import com.muse.manager.message.model.MessageSendExample;
import java.util.List;

import com.muse.manager.message.model.MessageSendHistoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/5
 **/
@Mapper
public interface MessageSendMapper {
    long countByExample(MessageSendExample example);

    int deleteByExample(MessageSendExample example);

    List<MessageSendHistoryVo> selectAllMessageSendHistory(long uid);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MessageSend record);

    int insertOrUpdate(MessageSend record);

    int insertOrUpdateSelective(MessageSend record);

    int insertOrUpdateWithBLOBs(MessageSend record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MessageSend record);

    List<MessageSend> selectByExampleWithBLOBs(MessageSendExample example);

    List<MessageSend> selectByExample(MessageSendExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MessageSend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageSend record, @Param("example") MessageSendExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageSend record, @Param("example") MessageSendExample example);

    int updateByExample(@Param("record") MessageSend record, @Param("example") MessageSendExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MessageSend record);

    int updateByPrimaryKeyWithBLOBs(MessageSend record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MessageSend record);

    int updateBatch(List<MessageSend> list);

    int batchInsert(@Param("list") List<MessageSend> list);
}