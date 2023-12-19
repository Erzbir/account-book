package com.erzbir.accountbook.core.component;

import com.erzbir.accountbook.component.AbstractComponent;
import com.erzbir.accountbook.component.BillManageComponent;
import com.erzbir.accountbook.core.entity.BillContainerProvider;
import com.erzbir.accountbook.entity.BillContainer;
import com.erzbir.accountbook.entity.IBill;
import com.erzbir.accountbook.event.BillAddEvent;
import com.erzbir.accountbook.event.BillDeleteEvent;
import com.erzbir.accountbook.event.BillUpdateEvent;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultBillManageComponent extends AbstractComponent implements BillManageComponent {
    private BillContainer billContainer;

    @Override
    public void add(IBill bill) {
        if (bill.isPlus()) {
            addIncome(bill);
        } else {
            addPay(bill);
        }
    }

    private void add0(IBill bill) {
        billContainer.add(bill);
        broadcastEvent(new BillAddEvent(bill));
    }

    @Override
    public void addPay(IBill bill) {
        bill.setPlus(false);
        add0(bill);
    }

    @Override
    public void addIncome(IBill bill) {
        bill.setPlus(true);
        add0(bill);
    }

    @Override
    public void update(IBill bill) {
        billContainer.update(bill);
        broadcastEvent(new BillUpdateEvent(bill));
    }

    @Override
    public void remove(IBill bill) {
        billContainer.remove(bill.getId());
        broadcastEvent(new BillDeleteEvent(bill));
    }

    @Override
    public boolean contains(IBill bill) {
        return billContainer.contains(bill);
    }

    @Override
    public List<IBill> getBills() {
        return billContainer.getItems().values().stream().toList();
    }

    @Override
    public void init() {
        billContainer = BillContainerProvider.getImpl();
        isInit.set(true);
    }
}
