package com.erzbir.accountbook.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.erzbir.accountbook.entity.Bill;
import com.erzbir.accountbook.entity.User;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Database(entities = {User.class, Bill.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            AppDatabase.class, "test").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();

    public abstract BillDao billDao();
}
