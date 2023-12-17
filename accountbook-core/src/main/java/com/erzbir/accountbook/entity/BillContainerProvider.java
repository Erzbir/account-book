package com.erzbir.accountbook.entity;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class BillContainerProvider {
    public static final BillContainer INSTANCE = ServiceLoader.load(BillContainer.class).findFirst().orElseThrow();
}
