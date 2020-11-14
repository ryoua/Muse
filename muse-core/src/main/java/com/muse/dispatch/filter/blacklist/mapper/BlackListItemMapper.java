package com.muse.dispatch.filter.blacklist.mapper;

import com.muse.dispatch.filter.blacklist.model.BlackListItem;
import com.muse.dispatch.filter.blacklist.model.BlackListItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/14
**/
@Mapper
public interface BlackListItemMapper {
    long countByExample(BlackListItemExample example);

    int deleteByExample(BlackListItemExample example);

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
    int insert(BlackListItem record);

    int insertOrUpdate(BlackListItem record);

    int insertOrUpdateSelective(BlackListItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BlackListItem record);

    List<BlackListItem> selectByExample(BlackListItemExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    BlackListItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlackListItem record, @Param("example") BlackListItemExample example);

    int updateByExample(@Param("record") BlackListItem record, @Param("example") BlackListItemExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BlackListItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BlackListItem record);

    int updateBatch(List<BlackListItem> list);

    int batchInsert(@Param("list") List<BlackListItem> list);
}