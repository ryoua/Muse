package com.muse.threadLocal;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
public class UserLocal {
    private static final ThreadLocal<Long> userIdLocal = new ThreadLocal<>();

    public static void setUserId(Long userId) { userIdLocal.set(userId); }

    public static Long getCurrentUserId() { return userIdLocal.get(); }
}
