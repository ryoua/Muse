package com.muse.validator;

import com.muse.exception.MuseException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new MuseException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new MuseException(message);
        }
    }
}
