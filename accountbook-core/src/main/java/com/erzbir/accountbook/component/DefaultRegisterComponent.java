package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IUser;
import com.erzbir.accountbook.entity.UserContainer;
import com.erzbir.accountbook.entity.UserContainerProvider;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultRegisterComponent extends AbstractComponent implements RegisterComponent {
    private UserContainer userContainer;

    @Override
    public void init() {
        userContainer = UserContainerProvider.INSTANCE;
        isInit.set(true);
    }

    @Override
    public boolean register(IUser user) {
        userContainer.add(user);
        return true;
    }
}
