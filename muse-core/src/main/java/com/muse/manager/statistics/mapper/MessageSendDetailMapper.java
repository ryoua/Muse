package com.muse.manager.statistics.mapper;

import com.muse.manager.mee.model.MessageSendDetail;
import com.muse.manager.mee.model.MessageSendDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/11
**/
@Mapper
public interface MessageSendDetailMapper {
    long countByExample(MessageSendDetailExample example);

    int deleteByExample(MessageSendDetailExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MessageSendDetail record);

    int insertOrUpdate(MessageSendDetail record);

    int insertOrUpdateSelective(MessageSendDetail record);

    int insertOrUpdateWithBLOBs(MessageSendDetail record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MessageSendDetail record);

    List<MessageSendDetail> selectByExampleWithBLOBs(MessageSendDetailExample example);

    List<MessageSendDetail> selectByExample(MessageSendDetailExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MessageSendDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageSendDetail record, @Param("example") MessageSendDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageSendDetail record, @Param("example") MessageSendDetailExample example);

    int updateByExample(@Param("record") MessageSendDetail record, @Param("example") MessageSendDetailExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MessageSendDetail record);

    int updateByPrimaryKeyWithBLOBs(MessageSendDetail record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MessageSendDetail record);

    int updateBatch(List<MessageSendDetail> list);

    int batchInsert(@Param("list") List<MessageSendDetail> list);
}