package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.AccountBookManageComponent;
import com.erzbir.accountbook.component.LoginComponent;
import com.erzbir.accountbook.component.RegisterComponent;
import com.erzbir.accountbook.component.SettingComponent;
import com.erzbir.accountbook.component.backup.BackupComponent;
import com.erzbir.accountbook.event.LifeCycleEvent;
import com.erzbir.accountbook.event.LifeCycleListener;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public abstract class AbstractApplication implements Application, ApplicationEventPublisher {
    protected BackupComponent backupComponent;
    protected AccountBookManageComponent accountBookManageComponent;
    protected LoginComponent loginComponent;
    protected RegisterComponent registerComponent;
    protected SettingComponent settingComponent;
    protected Set<LifeCycleListenerRegistry> listeners = new LinkedHashSet<>();

    @Override
    public void init() {
        initComponents();
    }

    public void initComponents() {
        initBackupComponent();
        intiSettingComponent();
        initAccountBookManagerComponent();
        initLoginComponent();
        initRegisterComponent();
    }

    @Override
    public void publishEvent(LifeCycleEvent event) {
        for (LifeCycleListenerRegistry listenerRegistry : listeners) {
            if (listenerRegistry.eventType.isInstance(event)) {
                listenerRegistry.listener.onEvent(event);
            }
        }
    }

    @Override
    public <E extends LifeCycleEvent> void addLifeCycleListener(LifeCycleListener<E> lifeCycleListener, Class<E> eventType) {
        listeners.add(new LifeCycleListenerRegistry(lifeCycleListener, eventType));
    }

    @Override
    public AccountBookManageComponent getAccountBookManagerComponent() {
        return null;
    }

    @Override
    public BackupComponent getBackupComponent() {
        return null;
    }

    @Override
    public LoginComponent getLoginComponent() {
        if (!loginComponent.isInit()) {
            loginComponent.init();
        }
        return loginComponent;
    }

    @Override
    public RegisterComponent getRegisterComponent() {
        if (!registerComponent.isInit()) {
            registerComponent.init();
        }
        return registerComponent;
    }

    @Override
    public SettingComponent getSettingComponent() {
        return null;
    }

    public void initRegisterComponent() {

    }

    public abstract void initBackupComponent();

    public abstract void initAccountBookManagerComponent();

    public abstract void initLoginComponent();

    public abstract void intiSettingComponent();

}
