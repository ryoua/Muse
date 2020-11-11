package com.muse.common.util;

import java.util.regex.Pattern;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/11
 **/
public class DigestUtil {
    public static boolean isMatchEmail(String email) {
        return Pattern.matches("\"^\\w+([-+.]\\w+)@\\w+([-.]\\w+).\\w+([-.]\\w+)$\"", email);
    }
}
