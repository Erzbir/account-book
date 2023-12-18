package com.erzbir.accountbook.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
@Entity(tableName = "user")
public class User implements IUser {
    @PrimaryKey(autoGenerate = false)
    private Integer id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder id(Integer id) {
            user.setId(id);
            return this;
        }

        public Builder username(String username) {
            user.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }

        public User build() {
            return user;
        }

    }
}
