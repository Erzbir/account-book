package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IAccountBook;
import com.erzbir.event.AbstractEvent;
import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class AccountBookRemoveEvent extends AbstractEvent implements Event {
    public AccountBookRemoveEvent(IAccountBook source) {
        super(source);
    }

    @Override
    public IAccountBook getSource() {
        return (IAccountBook) source;
    }
}
