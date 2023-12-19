package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.Event;

public interface BillEvent extends Event {
    @Override
    IBill getSource();
}
