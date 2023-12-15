package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.DefaultLoginComponent;
import com.erzbir.accountbook.component.DefaultRegisterComponent;
import com.erzbir.accountbook.event.StartupEvent;
import com.erzbir.accountbook.event.StopEvent;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class InternalDefaultApplication extends AbstractApplication implements Application {
    public static final InternalDefaultApplication INSTANCE = new InternalDefaultApplication();

    @Override
    public void initRegisterComponent() {
        registerComponent = new DefaultRegisterComponent();
    }

    @Override
    public void initBackupComponent() {

    }

    @Override
    public void initAccountBookManagerComponent() {

    }

    @Override
    public void initLoginComponent() {
        loginComponent = new DefaultLoginComponent();
    }

    @Override
    public void intiSettingComponent() {

    }

    @Override
    public void start() {
        publishEvent(new StartupEvent(this));
    }

    @Override
    public void stop() {
        publishEvent(new StopEvent(this));
    }
}
