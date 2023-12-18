package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.*;
import com.erzbir.accountbook.component.backup.BackupComponent;
import com.erzbir.accountbook.event.LifeCycleEvent;
import com.erzbir.accountbook.event.LifeCycleListener;
import com.erzbir.event.Event;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultApplication extends AbstractApplication implements Application {
    private AbstractApplication delegate;

    public DefaultApplication() {
        delegate = (AbstractApplication) ServiceLoader.load(ApplicationProvider.class).findFirst().orElseThrow().getInstance();
        delegate.init();
    }

    @Override
    public void initRegisterComponent() {
        delegate.initRegisterComponent();
    }

    @Override
    public void initBackupComponent() {
        delegate.initBackupComponent();
    }

    @Override
    public void initBillManageComponent() {
        delegate.initBillManageComponent();
    }

    @Override
    public void initLoginComponent() {
        delegate.initLoginComponent();
    }

    @Override
    public void intiSettingComponent() {
        delegate.intiSettingComponent();
    }

    @Override
    public void initUserManageComponent() {
        delegate.initUserManageComponent();
    }

    @Override
    public void broadcast(Event event) {
        delegate.broadcast(event);
    }

    @Override
    public BillManageComponent getBillManagerComponent() {
        return delegate.getBillManagerComponent();
    }

    @Override
    public BackupComponent getBackupComponent() {
        return delegate.getBackupComponent();
    }

    @Override
    public LoginComponent getLoginComponent() {
        return delegate.getLoginComponent();
    }

    @Override
    public RegisterComponent getRegisterComponent() {
        return delegate.getRegisterComponent();
    }

    @Override
    public SettingComponent getSettingComponent() {
        return delegate.getSettingComponent();
    }

    @Override
    public UserManageComponent getUserManageComponent() {
        return delegate.getUserManageComponent();
    }

    @Override
    public <E extends LifeCycleEvent> void addLifeCycleListener(LifeCycleListener<E> lifeCycleListener, Class<E> eventType) {
        delegate.addLifeCycleListener(lifeCycleListener, eventType);
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }
}
