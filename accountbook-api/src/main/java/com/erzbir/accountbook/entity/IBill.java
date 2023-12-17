package com.erzbir.accountbook.entity;

import java.io.Serializable;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface IBill extends Serializable {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDetail();

    void setDetail(String detail);

    Float getMoney();

    void setMoney(Float money);

    Long getTime();

    void setTime(Long time);

    Boolean isPlus();

    void setPlus(Boolean plus);
}
