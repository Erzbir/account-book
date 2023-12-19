package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IUser;
import com.erzbir.event.AbstractEvent;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class UserRegisterEvent extends AbstractEvent implements UserEvent {
    public UserRegisterEvent(IUser source) {
        super(source);
    }

    @Override
    public IUser getSource() {
        return (IUser) source;
    }
}
