package com.erzbir.accountbook.core.entity;

import com.erzbir.accountbook.entity.BillContainer;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class BillContainerProvider {
    private static volatile BillContainer INSTANCE;

    public static BillContainer getImpl() {
        if (INSTANCE == null) {
            synchronized (BillContainerProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = ServiceLoader.load(BillContainer.class, BillContainerProvider.class.getClassLoader()).findFirst().orElseThrow();
                }
            }
        }
        return INSTANCE;
    }
}
