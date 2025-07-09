package com.ty.hh.edu.holder;

public class UserContextHolder {
    private static final ThreadLocal<Long> userHolder = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        userHolder.set(userId);
    }

    public static Long getUserId() {
        return 1L;
        // TODO 先用测试用户
//        return userHolder.get();
    }

    public static void clear() {
        userHolder.remove();
    }
}
