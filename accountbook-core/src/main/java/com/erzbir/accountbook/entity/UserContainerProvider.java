package com.erzbir.accountbook.entity;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class UserContainerProvider {
    public static final UserContainer INSTANCE = ServiceLoader.load(UserContainer.class).findFirst().orElseThrow();
}
