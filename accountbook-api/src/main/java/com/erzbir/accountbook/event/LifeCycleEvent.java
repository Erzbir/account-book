package com.erzbir.accountbook.event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface LifeCycleEvent {
    Object getSource();

    long timestamp();
}
