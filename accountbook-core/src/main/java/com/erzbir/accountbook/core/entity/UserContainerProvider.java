package com.erzbir.accountbook.core.entity;

import com.erzbir.accountbook.entity.UserContainer;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class UserContainerProvider {
    private static volatile UserContainer INSTANCE;

    public static UserContainer getImpl() {
        if (INSTANCE == null) {
            synchronized (UserContainerProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = ServiceLoader.load(UserContainer.class).findFirst().orElseThrow();
                }
            }
        }
        return INSTANCE;
    }
}
