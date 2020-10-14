package com.muse.dispatcher.filter;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@Component
@Scope(value = "prototype")
public class DistinctFilter implements Filter {
    public List<String> idList;

    public DistinctFilter(List<String> idList) {
        this.idList = idList;
    }

    @Override
    public boolean doFilter() {
        boolean checkResult = checkIdList(idList);
        if (checkResult) {
            idList = idList.stream().distinct().collect(Collectors.toList());
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIdList(List<String> idList) {
        if (idList == null || idList.size() == 0) {
            return false;
        }
        return true;
    }
}
