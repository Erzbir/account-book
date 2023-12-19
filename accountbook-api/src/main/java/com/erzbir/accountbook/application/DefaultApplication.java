package com.erzbir.accountbook.application;

import com.erzbir.accountbook.component.*;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultApplication extends AbstractApplication implements Application {
    @Override
    public void initRegisterComponent() {
        registerComponent = ServiceLoader.load(RegisterComponent.class, DefaultApplication.class.getClassLoader()).findFirst().orElseThrow();
    }

    @Override
    public void initBackupComponent() {
        backupComponent = ServiceLoader.load(BackupComponent.class).findFirst().orElseThrow();
    }

    @Override
    public void initBillManageComponent() {
        billManageComponent = ServiceLoader.load(BillManageComponent.class).findFirst().orElseThrow();
    }

    @Override
    public void initLoginComponent() {
        loginComponent = ServiceLoader.load(LoginComponent.class).findFirst().orElseThrow();
    }

    @Override
    public void initUserManageComponent() {
        userManageComponent = ServiceLoader.load(UserManageComponent.class).findFirst().orElseThrow();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
