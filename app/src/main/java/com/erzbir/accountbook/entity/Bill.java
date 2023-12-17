package com.erzbir.accountbook.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Entity(tableName = "bill")
public class Bill implements IBill {
    @PrimaryKey(autoGenerate = false)
    private Integer id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "detail")
    private String detail;

    @ColumnInfo(name = "money")
    private Float money;

    @ColumnInfo(name = "plus")
    private Boolean plus;

    @ColumnInfo(name = "time")
    private Long time;

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDetail() {
        return detail;
    }

    @Override
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public Float getMoney() {
        return plus ? money : -money;
    }

    @Override
    public void setMoney(Float money) {
        this.money = Math.abs(money);
    }

    @Override
    public Long getTime() {
        return time;
    }

    @Override
    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public Boolean isPlus() {
        return plus;
    }

    @Override
    public void setPlus(Boolean plus) {
        this.plus = plus;
    }

    public static class Builder {
        private final Bill bill;

        public Builder() {
            bill = new Bill();
        }

        public Builder name(String name) {
            bill.setName(name);
            return this;
        }

        public Builder detail(String detail) {
            bill.setDetail(detail);
            return this;
        }

        public Builder money(Float money) {
            bill.setMoney(money);
            return this;
        }

        public Builder plus(Boolean plus) {
            bill.setPlus(plus);
            return this;
        }

        public Builder time(Long time) {
            bill.setTime(time);
            return this;
        }

        public Bill build() {
            return bill;
        }
    }
}
