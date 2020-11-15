package com.muse.dispatch.filter.blacklist.service;

import com.muse.dispatch.filter.blacklist.mapper.BlackListItemMapper;
import com.muse.dispatch.filter.blacklist.mapper.BlackListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/14
 **/
@Service
public class BlackListService {
    @Autowired
    private BlackListMapper blackListMapper;
    @Autowired
    private BlackListItemMapper blackListItemMapper;
}
