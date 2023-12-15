package com.erzbir;


import com.erzbir.accountbook.application.Application;
import com.erzbir.accountbook.application.DefaultApplication;
import com.erzbir.accountbook.component.LoginComponent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Application APP = new DefaultApplication();
        APP.init();
        LoginComponent loginComponent = APP.getLoginComponent();
        loginComponent.init();
    }
}