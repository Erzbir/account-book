package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IUser;
import com.erzbir.accountbook.entity.UserContainer;
import com.erzbir.accountbook.entity.UserContainerProvider;

public class DefaultUserManageComponent extends AbstractComponent implements UserManageComponent{
    private UserContainer userContainer;

    @Override
    public void init() {
        userContainer = UserContainerProvider.INSTANCE;
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
