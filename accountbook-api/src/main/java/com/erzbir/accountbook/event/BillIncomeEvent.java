package com.erzbir.accountbook.event;

import com.erzbir.accountbook.entity.IBill;
import com.erzbir.event.Event;

public class BillIncomeEvent extends BillEvent implements Event {
    public BillIncomeEvent(IBill source) {
        super(source);
    }
}
