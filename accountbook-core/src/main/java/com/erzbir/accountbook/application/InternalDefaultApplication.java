package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.DefaultBillManageComponent;
import com.erzbir.accountbook.component.DefaultLoginComponent;
import com.erzbir.accountbook.component.DefaultRegisterComponent;
import com.erzbir.accountbook.event.StartupEvent;
import com.erzbir.accountbook.event.StopEvent;
import com.erzbir.context.DefaultApplication;
import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class InternalDefaultApplication extends AbstractApplication implements Application {
    public static final InternalDefaultApplication INSTANCE = new InternalDefaultApplication();
    private com.erzbir.context.Application application = new DefaultApplication();

    @Override
    public void initRegisterComponent() {
        registerComponent = new DefaultRegisterComponent();
    }

    @Override
    public void initBackupComponent() {

    }

    @Override
    public void initBillManageComponent() {
        billManageComponent = new DefaultBillManageComponent();
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

    @Override
    public void broadcast(Event event) {
        application.broadcastEvent(event);
    }
}
