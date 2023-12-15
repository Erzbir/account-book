package com.erzbir.accountbook.entity;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface IAccountBook {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDetail();

    void setDetail(String detail);

    float getMoney();

    void setMoney(float money);

    Boolean isPlus();

    void setPlus(Boolean plus);
}
