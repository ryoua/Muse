package com.muse.common.local;

public class UserLocal {
    public static ThreadLocal<Long> userLocal = new ThreadLocal<>();

    public static void setUserId(Long uid) {
       userLocal.set(uid);
    }

    public static Long getUserId() {
        return userLocal.get();
    }
}
