package com.erzbir.accountbook.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.erzbir.accountbook.entity.User;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE username = :username")
    User findByName(String username);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
