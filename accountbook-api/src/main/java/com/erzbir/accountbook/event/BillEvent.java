package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.AbstractEvent;
import com.erzbir.event.Event;

public abstract class BillEvent extends AbstractEvent implements Event {
    public BillEvent(IBill source) {
        super(source);
    }

    @Override
    public IBill getSource() {
        return (IBill) source;
    }
}
