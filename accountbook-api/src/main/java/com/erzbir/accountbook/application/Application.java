package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.*;
import com.erzbir.accountbook.component.backup.BackupComponent;
import com.erzbir.accountbook.event.LifeCycleEvent;
import com.erzbir.accountbook.event.LifeCycleListener;
import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface Application extends LifeCycle {
    void broadcast(Event event);

    BillManageComponent getBillManagerComponent();

    BackupComponent getBackupComponent();

    LoginComponent getLoginComponent();

    RegisterComponent getRegisterComponent();

    SettingComponent getSettingComponent();

    UserManageComponent getUserManageComponent();

    <E extends LifeCycleEvent> void addLifeCycleListener(LifeCycleListener<E> lifeCycleListener, Class<E> eventType);

    void init();
}
