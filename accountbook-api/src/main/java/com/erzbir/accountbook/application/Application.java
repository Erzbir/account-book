package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.AccountBookManageComponent;
import com.erzbir.accountbook.component.LoginComponent;
import com.erzbir.accountbook.component.RegisterComponent;
import com.erzbir.accountbook.component.SettingComponent;
import com.erzbir.accountbook.component.backup.BackupComponent;
import com.erzbir.accountbook.event.LifeCycleEvent;
import com.erzbir.accountbook.event.LifeCycleListener;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface Application extends LifeCycle {
    AccountBookManageComponent getAccountBookManagerComponent();

    BackupComponent getBackupComponent();

    LoginComponent getLoginComponent();

    RegisterComponent getRegisterComponent();

    SettingComponent getSettingComponent();

    <E extends LifeCycleEvent> void addLifeCycleListener(LifeCycleListener<E> lifeCycleListener, Class<E> eventType);

    void init();
}
