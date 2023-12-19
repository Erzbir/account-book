package com.erzbir.accountbook.component;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface BackupStrategy {
    void backup(Object object);

    String getName();

    boolean isEnable();
}
