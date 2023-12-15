package com.erzbir.accountbook.event;

import java.util.EventListener;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface LifeCycleListener<E extends LifeCycleEvent> extends EventListener {
    void onEvent(E event);
}
