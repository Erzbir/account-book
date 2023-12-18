package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.*;
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
    protected BillManageComponent billManageComponent;
    protected LoginComponent loginComponent;
    protected RegisterComponent registerComponent;
    protected SettingComponent settingComponent;
    protected UserManageComponent userManageComponent;
    protected Set<LifeCycleListenerRegistry> listeners = new LinkedHashSet<>();

    @Override
    public void init() {
        initComponents();
    }

    public void initComponents() {
        initBackupComponent();
        intiSettingComponent();
        initBillManageComponent();
        initLoginComponent();
        initRegisterComponent();
        initUserManageComponent();
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
    public BillManageComponent getBillManagerComponent() {
        if (!billManageComponent.isInit()) {
            billManageComponent.init();
        }
        return billManageComponent;
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
    public UserManageComponent getUserManageComponent() {
        if (!userManageComponent.isInit()) {
            userManageComponent.init();
        }
        return userManageComponent;
    }


    @Override
    public SettingComponent getSettingComponent() {
        return null;
    }

    public abstract void initRegisterComponent();

    public abstract void initBackupComponent();

    public abstract void initBillManageComponent();

    public abstract void initLoginComponent();

    public abstract void intiSettingComponent();

    public abstract void initUserManageComponent();

}
