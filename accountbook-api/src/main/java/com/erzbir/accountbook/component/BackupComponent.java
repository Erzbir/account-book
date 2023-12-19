package com.erzbir.accountbook.component;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface BackupComponent extends Component {
    BackupStrategy getBackupStrategy(String name);

    void addBackupStrategy(BackupStrategy backupStrategy);

    void backup(Object object);
}
