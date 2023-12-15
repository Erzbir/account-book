package com.erzbir.event;

import java.util.EventListener;

/**
 * @author Erzbir
 * @Data: 2023/12/6 10:49
 */
public interface Listener<E extends Event> extends EventListener {
    ListenerStatus onEvent(E event);

    enum ListenerStatus {
        LISTENING,
        STOPPED
    }
}