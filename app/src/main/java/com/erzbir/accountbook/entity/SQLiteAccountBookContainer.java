package com.erzbir.accountbook.entity;

import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.dao.AccountBookDao;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class SQLiteAccountBookContainer implements AccountBookContainer {
    private final Map<Integer, IAccountBook> accountBookMap = new ConcurrentHashMap<>();
    private final AccountBookDao accountBookDao = AndroidApplication.INSTANCE.DB.accountBookDao();

    public SQLiteAccountBookContainer() {
        accountBookDao.getAll().forEach(v -> accountBookMap.put(v.getId(), v));
    }

    @Override
    public void add(IAccountBook accountBook) {
        accountBookMap.put(accountBook.getId(), accountBook);
        CompletableFuture.runAsync(() -> accountBookDao.insertAll((AccountBook) accountBook));
    }

    @Override
    public IAccountBook get(Integer key) {
        return accountBookMap.get(key);
    }

    @Override
    public void remove(Integer key) {
        accountBookMap.remove(key);
        AccountBook accountBook = new AccountBook();
        accountBook.setId(key);
        CompletableFuture.runAsync(() -> accountBookDao.delete(accountBook));
    }

    @Override
    public boolean contains(IAccountBook accountBook) {
        return accountBookMap.containsKey(accountBook.getId());
    }

    @Override
    public Map<Integer, IAccountBook> getItems() {
        return null;
    }
}
