package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.AbstractEvent;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class BillDeleteEvent extends AbstractEvent implements BillEvent {
    public BillDeleteEvent(IBill source) {
        super(source);
    }

    @Override
    public IBill getSource() {
        return (IBill) source;
    }
}
