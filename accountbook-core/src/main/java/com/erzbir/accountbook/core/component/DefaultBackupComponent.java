package com.erzbir.accountbook.core.component;

import com.erzbir.accountbook.component.AbstractComponent;
import com.erzbir.accountbook.component.BackupComponent;
import com.erzbir.accountbook.component.BackupStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Erzbir
 * @Data: 2023/12/18
 */
public class DefaultBackupComponent extends AbstractComponent implements BackupComponent {
    private final Map<String, BackupStrategy> backupStrategies = new LinkedHashMap<>();

    @Override
    public BackupStrategy getBackupStrategy(String name) {
        return backupStrategies.get(name);
    }

    @Override
    public void addBackupStrategy(BackupStrategy backupStrategy) {
        if (backupStrategies.containsKey(backupStrategy.getName())) {
            return;
        }
        backupStrategies.put(backupStrategy.getName(), backupStrategy);
    }

    @Override
    public void backup(Object object) {
        if (backupStrategies.isEmpty()) {
            return;
        }
        backupStrategies.forEach((s, backupStrategy) -> {
            try {
                if (backupStrategy.isEnable()) {
                    backupStrategy.backup(object);
                }
            } catch (Exception ignore) {

            }
        });
    }

    @Override
    public void init() {
        isInit.set(true);
    }
}
