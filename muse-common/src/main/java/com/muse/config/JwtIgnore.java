package com.muse.config;

import java.lang.annotation.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}

