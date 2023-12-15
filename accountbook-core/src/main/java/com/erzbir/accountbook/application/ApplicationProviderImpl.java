package com.erzbir.accountbook.application;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class ApplicationProviderImpl implements ApplicationProvider {
    @Override
    public Application getInstance() {
        return InternalDefaultApplication.INSTANCE;
    }
}
