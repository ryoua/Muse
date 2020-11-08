package com.muse.manager.statistics.mapper;

import com.muse.manager.statistics.model.MessageSendStatistics;
import com.muse.manager.statistics.model.MessageSendStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/8
**/
@Mapper
public interface MessageSendStatisticsMapper {
    long countByExample(MessageSendStatisticsExample example);

    int deleteByExample(MessageSendStatisticsExample example);

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
    int insert(MessageSendStatistics record);

    int insertOrUpdate(MessageSendStatistics record);

    int insertOrUpdateSelective(MessageSendStatistics record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MessageSendStatistics record);

    List<MessageSendStatistics> selectByExample(MessageSendStatisticsExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MessageSendStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageSendStatistics record, @Param("example") MessageSendStatisticsExample example);

    int updateByExample(@Param("record") MessageSendStatistics record, @Param("example") MessageSendStatisticsExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MessageSendStatistics record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MessageSendStatistics record);

    int updateBatch(List<MessageSendStatistics> list);

    int batchInsert(@Param("list") List<MessageSendStatistics> list);
}