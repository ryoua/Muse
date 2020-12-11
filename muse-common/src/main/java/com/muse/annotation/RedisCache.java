package com.muse.annotation;

import java.lang.annotation.*;

/**
 * Redis缓存
 * @author：ryoua
 * @date：2020/12/10
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
    String key();

    int type();

    String value();
}
