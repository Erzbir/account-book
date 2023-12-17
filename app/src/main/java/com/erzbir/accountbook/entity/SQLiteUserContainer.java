package com.erzbir.accountbook.entity;

import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.dao.UserDao;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class SQLiteUserContainer implements UserContainer {
    private final Map<String, IUser> userMap = new ConcurrentHashMap<>();
    private final UserDao userDao = AndroidApplication.INSTANCE.DB.userDao();

    public SQLiteUserContainer() {
        userDao.getAll().forEach(v -> userMap.put(v.getUsername(), v));
    }

    @Override
    public void add(IUser user) {
        if (user.getId() == null || user.getId() == 0) {
            user.setId(userMap.size() + 1);
        }
        userMap.put(user.getUsername(), user);
        CompletableFuture.runAsync(() -> userDao.insertAll((User) user));
    }

    @Override
    public User get(String key) {
        return (User) userMap.get(key);
    }

    @Override
    public void remove(String key) {
        IUser remove = userMap.remove(key);
        CompletableFuture.runAsync(() -> userDao.delete((User) remove));
    }

    @Override
    public boolean contains(IUser user) {
        return userMap.containsKey(user.getUsername());
    }

    @Override
    public Map<String, IUser> getItems() {
        return userMap;
    }
}
