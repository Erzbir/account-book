package com.erzbir.accountbook.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.erzbir.accountbook.entity.Bill;
import com.erzbir.accountbook.entity.User;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Database(entities = {User.class, Bill.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract BillDao billDao();
}
