package com.erzbir.accountbook.dao;

import androidx.room.*;
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

    @Update
    void update(User user);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
