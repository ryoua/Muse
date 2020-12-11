package com.muse.common.util;

import java.util.regex.Pattern;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/11
 **/
public class DigestUtil {
    public static boolean isMatchEmail(String str) {
        return Pattern.matches("\"^\\w+([-+.]\\w+)@\\w+([-.]\\w+).\\w+([-.]\\w+)$\"", str);
    }

    public static boolean isMatchPhone(String str) {
        return Pattern.matches("^((\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$", str);
    }

    public static boolean isMatchNum(String str) {
        return Pattern.matches("^[0-9]$", str);
    }
}
