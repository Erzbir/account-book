package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.Event;

public class BillPayEvent extends BillEvent implements Event {
    public BillPayEvent(IBill source) {
        super(source);
    }
}
