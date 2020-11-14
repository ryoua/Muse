package com.muse.dispatch.filter.whitelist.mapper;

import com.muse.dispatch.filter.whitelist.model.WhiteList;
import com.muse.dispatch.filter.whitelist.model.WhiteListExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/14
**/
@Mapper
public interface WhiteListMapper {
    long countByExample(WhiteListExample example);

    int deleteByExample(WhiteListExample example);

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
    int insert(WhiteList record);

    int insertOrUpdate(WhiteList record);

    int insertOrUpdateSelective(WhiteList record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(WhiteList record);

    List<WhiteList> selectByExample(WhiteListExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    WhiteList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WhiteList record, @Param("example") WhiteListExample example);

    int updateByExample(@Param("record") WhiteList record, @Param("example") WhiteListExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(WhiteList record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(WhiteList record);

    int updateBatch(List<WhiteList> list);

    int batchInsert(@Param("list") List<WhiteList> list);
}