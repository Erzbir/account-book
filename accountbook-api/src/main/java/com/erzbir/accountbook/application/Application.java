package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.*;
import com.erzbir.accountbook.event.LifeCycleEvent;
import com.erzbir.accountbook.event.LifeCycleListener;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface Application extends LifeCycle {

    BillManageComponent getBillManagerComponent();

    BackupComponent getBackupComponent();

    LoginComponent getLoginComponent();

    RegisterComponent getRegisterComponent();

    UserManageComponent getUserManageComponent();

    <E extends LifeCycleEvent> void addLifeCycleListener(LifeCycleListener<E> lifeCycleListener, Class<E> eventType);

    void init();
}
