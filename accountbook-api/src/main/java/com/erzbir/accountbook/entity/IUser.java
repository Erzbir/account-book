package com.erzbir.accountbook.entity;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface IUser {

    Integer getId();

    void setId(Integer id);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);
}
