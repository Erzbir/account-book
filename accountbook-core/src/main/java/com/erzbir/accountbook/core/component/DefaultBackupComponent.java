package com.erzbir.accountbook.core.component;

import com.erzbir.accountbook.component.AbstractComponent;
import com.erzbir.accountbook.component.BackupComponent;
import com.erzbir.accountbook.component.BackupStrategy;

/**
 * @author Erzbir
 * @Data: 2023/12/18
 */
public class DefaultBackupComponent extends AbstractComponent implements BackupComponent {
    private BackupStrategy backupStrategy;

    public BackupStrategy getBackupStrategy() {
        return backupStrategy;
    }

    public void setBackupStrategy(BackupStrategy backupStrategy) {
        this.backupStrategy = backupStrategy;
    }

    @Override
    public void init() {
        backupStrategy = BackupStrategyProvider.getImpl();
        isInit.set(true);
    }
}
