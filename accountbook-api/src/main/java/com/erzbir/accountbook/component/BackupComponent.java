package com.erzbir.accountbook.component;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface BackupComponent extends Component {
    BackupStrategy getBackupStrategy();

    void setBackupStrategy(BackupStrategy backupStrategy);
}
