package com.erzbir.accountbook.component;

import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface Component {
    void init();

    void disable();

    void active();

    boolean isInit();

    boolean isActive();

    void broadcastEvent(Event event);
}
