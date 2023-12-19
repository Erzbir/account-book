package com.erzbir.accountbook.util;

import com.erzbir.accountbook.entity.User;

/**
 * @author Erzbir
 * @Data: 2023/12/18
 */
public class SavedUser {
    public final static String REM_PASSWORD_KEY = "REM_PASSWORD";
    public final static String USERNAME_KEY = "USERNAME";
    public final static String PASSWORD_KEY = "PASSWORD";

    private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }
}
