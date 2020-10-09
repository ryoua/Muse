package com.muse.message.dispatcher.core.pipeline;

import com.muse.message.dispatcher.core.filter.Filter;

import java.util.List;

/**
 * 过滤器管道
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
public interface Pipeline {
    /**
     * 获取基础过滤器
     * @return
     */
    Filter getBasic();

    /**
     * 设置基础过滤器
     * @param filter
     */
    void setBasic(Filter filter);

    /**
     * 执行管道
     */
    void invoke();

    /**
     * 新增过滤器
     * @param filter
     */
    void addFilter(Filter filter);

    /**
     * 获取全部过滤器
     * @return
     */
    List<Filter> getFilters();

    /**
     * 移除过滤器
     * @param filter
     */
    void removeFilter(Filter filter);
}
