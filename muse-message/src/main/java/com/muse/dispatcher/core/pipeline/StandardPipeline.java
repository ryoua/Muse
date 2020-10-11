package com.muse.dispatcher.core.pipeline;

import com.muse.dispatcher.core.filter.BasicFilter;
import com.muse.dispatcher.core.filter.Filter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 管道基本实现类
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@Component
public class StandardPipeline implements Pipeline {
    private Filter basic = new BasicFilter();

    private List<Filter> filters = new ArrayList<>();

    private Object param;

    public StandardPipeline(Object param) {
        this.filters.add(basic);
        this.param = param;
    }

    @Override
    public Filter getBasic() {
        return basic;
    }

    @Override
    public void setBasic(Filter filter) {
        basic = filter;
    }

    @Override
    public void invoke() {
        filters.forEach(filter -> {
            filter.doFilter(param);
        });
    }

    @Override
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public List<Filter> getFilters() {
        return filters;
    }

    @Override
    public void removeFilter(Filter filter) {
        filters.removeIf(f -> f.equals(filter));
    }
}
