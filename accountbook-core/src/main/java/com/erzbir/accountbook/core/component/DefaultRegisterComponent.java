package com.erzbir.accountbook.core.component;

import com.erzbir.accountbook.component.AbstractComponent;
import com.erzbir.accountbook.component.RegisterComponent;
import com.erzbir.accountbook.core.entity.UserContainerProvider;
import com.erzbir.accountbook.entity.IUser;
import com.erzbir.accountbook.entity.UserContainer;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultRegisterComponent extends AbstractComponent implements RegisterComponent {
    private UserContainer userContainer;

    @Override
    public void init() {
        userContainer = UserContainerProvider.getImpl();
        isInit.set(true);
    }

    @Override
    public boolean register(IUser user) {
        userContainer.add(user);
        return true;
    }
}
