package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class BillAddEvent extends BillEvent implements Event {
    public BillAddEvent(IBill source) {
        super(source);
    }

}
