package com.muse.auth.threadlocal;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/11
 **/
public class UserThreadLocal {
    private final static ThreadLocal<Long> users = new ThreadLocal<>();

    public static Long getCurrentUser() {
        users.set(1L);
        return users.get();
    }

    public static void setCurrentUser(long userId) {
        users.set(userId);
    }
}
