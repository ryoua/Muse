package com.muse.dispatch.filter.whitelist.service;

import com.muse.dispatch.filter.whitelist.mapper.WhiteListItemMapper;
import com.muse.dispatch.filter.whitelist.mapper.WhiteListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/14
 **/
@Service
public class WhiteListService {
    @Autowired
    private WhiteListMapper whiteListMapper;
    @Autowired
    private WhiteListItemMapper whiteListItemMapper;
}
