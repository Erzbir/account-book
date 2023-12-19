package com.erzbir;

import com.erzbir.accountbook.entity.BillContainer;
import com.erzbir.accountbook.entity.IBill;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class MockBillContainer implements BillContainer {
    private final Map<Integer, IBill> billMap = new ConcurrentHashMap<>();

    public MockBillContainer() {

    }

    @Override
    public void add(IBill bill) {

    }

    @Override
    public IBill get(Integer key) {
        return null;
    }

    @Override
    public void remove(Integer key) {

    }

    @Override
    public void update(IBill bill) {

    }

    @Override
    public boolean contains(IBill bill) {
        return false;
    }

    @Override
    public Map<Integer, IBill> getItems() {
        return billMap;
    }
}
