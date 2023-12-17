package com.erzbir.accountbook.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.erzbir.accountbook.entity.Bill;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Dao
public interface BillDao {
    @Query("SELECT * FROM bill")
    List<Bill> getAll();

    @Query("SELECT * FROM bill WHERE id = :id")
    Bill findById(Integer id);

    @Insert
    void insertAll(Bill... bills);

    @Insert
    void insert(Bill bill);

    @Delete
    void delete(Bill bill);
}
