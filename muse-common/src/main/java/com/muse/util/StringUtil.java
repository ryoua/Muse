package com.muse.util;

import java.util.Random;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
public class StringUtil {
    public static String randomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static boolean isNotNull(String param) {
        return param != null && !"".equals(param);
    }
}
