package com.erzbir.accountbook.core.component;

import com.erzbir.accountbook.component.AbstractComponent;
import com.erzbir.accountbook.component.UserManageComponent;
import com.erzbir.accountbook.core.entity.UserContainerProvider;
import com.erzbir.accountbook.entity.IUser;
import com.erzbir.accountbook.entity.UserContainer;

public class DefaultUserManageComponent extends AbstractComponent implements UserManageComponent {
    private UserContainer userContainer;

    @Override
    public void init() {
        userContainer = UserContainerProvider.getImpl();
    }

    @Override
    public void update(IUser user) {
        userContainer.update(user);
    }

    @Override
    public IUser getUser(String key) {
        return userContainer.get(key);
    }
}
