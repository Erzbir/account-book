package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IUser;
import com.erzbir.accountbook.entity.UserContainer;
import com.erzbir.accountbook.entity.UserContainerProvider;
import com.erzbir.accountbook.event.UserLoginEvent;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultLoginComponent extends AbstractComponent implements LoginComponent {
    private UserContainer userContainer;

    @Override
    public boolean login(IUser user) {
        IUser user1 = userContainer.get(user.getUsername());
        broadcastEvent(new UserLoginEvent(user));
        if (!(user1 == null)) {
            return user1.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public void init() {
        userContainer = UserContainerProvider.INSTANCE;
        isInit.set(true);
    }
}
