package com.erzbir.accountbook.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Entity(tableName = "accountbook")
public class AccountBook implements IAccountBook {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "detail")
    private String detail;

    @ColumnInfo(name = "money")
    private float money;
    @ColumnInfo(name = "plus")
    private Boolean plus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Boolean isPlus() {
        return plus;
    }

    public void setPlus(Boolean plus) {
        this.plus = plus;
    }
}
