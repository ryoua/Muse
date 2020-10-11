package com.muse.dispatcher.core.filter;

/**
 * 过滤器接口
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
public interface Filter {
    /**
     * 过滤
     * @param o
     * @return boolean
     */
    boolean doFilter(Object o);
}
