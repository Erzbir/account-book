package com.erzbir.accountbook.component;

import com.erzbir.accountbook.application.InternalDefaultApplication;
import com.erzbir.accountbook.entity.BillContainer;
import com.erzbir.accountbook.entity.BillContainerProvider;
import com.erzbir.accountbook.entity.IBill;
import com.erzbir.accountbook.event.BillDeleteEvent;
import com.erzbir.accountbook.event.BillIncomeEvent;
import com.erzbir.accountbook.event.BillPayEvent;

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
    }

    @Override
    public void addPay(IBill bill) {
        bill.setPlus(false);
        add0(bill);
        InternalDefaultApplication.INSTANCE.broadcast(new BillPayEvent(bill));
    }

    @Override
    public void addIncome(IBill bill) {
        bill.setPlus(true);
        add0(bill);
        InternalDefaultApplication.INSTANCE.broadcast(new BillIncomeEvent(bill));
    }

    @Override
    public void update(IBill bill) {
        billContainer.update(bill);
    }

    @Override
    public void remove(IBill bill) {
        InternalDefaultApplication.INSTANCE.broadcast(new BillDeleteEvent(bill));
        billContainer.remove(bill.getId());
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
        billContainer = BillContainerProvider.INSTANCE;
        isInit.set(true);
    }
}
