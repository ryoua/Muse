package com.muse.annotation;

import java.lang.annotation.*;

/**
 * 线程安全的类
 * @author：ryoua
 * @date：2020/12/10
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThreadSafe {
}
