package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class BillDeleteEvent extends BillEvent implements Event {

    public BillDeleteEvent(IBill source) {
        super(source);
    }

}
