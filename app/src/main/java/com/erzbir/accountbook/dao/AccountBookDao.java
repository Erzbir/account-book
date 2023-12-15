package com.erzbir.accountbook.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.erzbir.accountbook.entity.AccountBook;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Dao
public interface AccountBookDao {
    @Query("SELECT * FROM accountbook")
    List<AccountBook> getAll();

    @Query("SELECT * FROM accountbook WHERE id = :id")
    AccountBook findById(Integer id);

    @Insert
    void insertAll(AccountBook... accountBooks);

    @Delete
    void delete(AccountBook accountBook);
}
