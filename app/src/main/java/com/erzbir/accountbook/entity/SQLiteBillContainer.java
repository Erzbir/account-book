package com.erzbir.accountbook.entity;

import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.dao.BillDao;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class SQLiteBillContainer implements BillContainer {
    private final Map<Integer, IBill> billMap = new ConcurrentHashMap<>();
    private final BillDao billDao = AndroidApplication.INSTANCE.DB.billDao();

    public SQLiteBillContainer() {
        billDao.getAll().forEach(v -> billMap.put(v.getId(), v));
    }

    @Override
    public void add(IBill bill) {
        if (bill.getId() == null || bill.getId() == 0) {
            bill.setId(billMap.size() + 1);
        }
        billMap.put(bill.getId(), bill);
        CompletableFuture.runAsync(() -> billDao.insert((Bill) bill));
    }

    @Override
    public IBill get(Integer key) {
        return billMap.get(key);
    }

    @Override
    public void remove(Integer key) {
        billMap.remove(key);
        Bill bill = new Bill();
        bill.setId(key);
        CompletableFuture.runAsync(() -> billDao.delete(bill));
    }

    @Override
    public void update(IBill bill) {
        billMap.put(bill.getId(), bill);
        CompletableFuture.runAsync(() -> billDao.update((Bill) bill));
    }

    @Override
    public boolean contains(IBill bill) {
        return billMap.containsKey(bill.getId());
    }

    @Override
    public Map<Integer, IBill> getItems() {
        return billMap;
    }
}
