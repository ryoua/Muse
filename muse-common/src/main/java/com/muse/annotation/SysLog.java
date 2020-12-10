package com.muse.annotation;

import java.lang.annotation.*;

/**
 * 日志打印
 * @author：ryoua
 * @date：2020/12/10
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
