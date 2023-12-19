package com.erzbir;

import com.erzbir.accountbook.entity.IUser;
import com.erzbir.accountbook.entity.UserContainer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class MockUserContainer implements UserContainer {
    private final Map<String, IUser> userMap = new ConcurrentHashMap<>();


    @Override
    public void add(IUser user) {

    }

    @Override
    public IUser get(String key) {
        return userMap.get(key);
    }

    @Override
    public void remove(String key) {
        IUser remove = userMap.remove(key);
    }

    @Override
    public void update(IUser user) {
        userMap.put(user.getUsername(), user);
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
