package com.muse.dispatch.filter.whitelist.mapper;

import com.muse.dispatch.filter.whitelist.model.WhiteListItem;
import com.muse.dispatch.filter.whitelist.model.WhiteListItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/14
**/
@Mapper
public interface WhiteListItemMapper {
    long countByExample(WhiteListItemExample example);

    int deleteByExample(WhiteListItemExample example);

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
    int insert(WhiteListItem record);

    int insertOrUpdate(WhiteListItem record);

    int insertOrUpdateSelective(WhiteListItem record);

    int insertOrUpdateWithBLOBs(WhiteListItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(WhiteListItem record);

    List<WhiteListItem> selectByExampleWithBLOBs(WhiteListItemExample example);

    List<WhiteListItem> selectByExample(WhiteListItemExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    WhiteListItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WhiteListItem record, @Param("example") WhiteListItemExample example);

    int updateByExampleWithBLOBs(@Param("record") WhiteListItem record, @Param("example") WhiteListItemExample example);

    int updateByExample(@Param("record") WhiteListItem record, @Param("example") WhiteListItemExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(WhiteListItem record);

    int updateByPrimaryKeyWithBLOBs(WhiteListItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(WhiteListItem record);

    int updateBatch(List<WhiteListItem> list);

    int batchInsert(@Param("list") List<WhiteListItem> list);
}