package com.erzbir.accountbook.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.erzbir.accountbook.entity.AccountBook;
import com.erzbir.accountbook.entity.User;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Database(entities = {User.class, AccountBook.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract AccountBookDao accountBookDao();
}
