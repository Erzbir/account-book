package com.erzbir.accountbook.dao;

import androidx.room.*;
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

    @Update
    void update(Bill bill);

    @Insert
    void insertAll(Bill... bills);

    @Insert
    void insert(Bill bill);

    @Delete
    void delete(Bill bill);
}
