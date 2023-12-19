package com.erzbir.accountbook.core.component;

import com.erzbir.accountbook.component.BackupStrategy;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/18
 */
public class BackupStrategyProvider {

    public static BackupStrategy getImpl() {
        return ServiceLoader.load(BackupStrategy.class).findFirst().orElse(object -> {
            throw new UnsupportedOperationException("not support");
        });
    }
}
