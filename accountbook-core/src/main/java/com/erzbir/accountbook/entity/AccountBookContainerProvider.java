package com.erzbir.accountbook.entity;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class AccountBookContainerProvider {
    public static final AccountBookContainer INSTANCE = ServiceLoader.load(AccountBookContainer.class).findFirst().orElseThrow();
}
