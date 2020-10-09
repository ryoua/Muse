package com.muse.message.dispatcher.core.filter;

import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@Component
public class BasicFilter implements Filter {
    @Override
    public boolean doFilter(Object o) {
        return true;
    }
}
