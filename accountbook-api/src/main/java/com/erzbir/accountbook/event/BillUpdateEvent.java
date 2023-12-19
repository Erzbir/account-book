package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.AbstractEvent;

public class BillUpdateEvent extends AbstractEvent implements BillEvent {
    public BillUpdateEvent(IBill source) {
        super(source);
    }

    @Override
    public IBill getSource() {
        return (IBill) source;
    }
}
