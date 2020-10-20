package com.muse.threadLocal;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
public class UserLocal {
    private static ThreadLocal<Long> userLocal = new ThreadLocal<>();

    public static void setUserId(Long userid) {
        userLocal.set(userid);
    }

    public static Long getUserId() {
        return userLocal.get();
    }
}
