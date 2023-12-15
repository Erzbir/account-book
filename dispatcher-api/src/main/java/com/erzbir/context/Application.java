package com.erzbir.context;

import com.erzbir.event.Event;

/**
 * @author Erzbir
 * @Data: 2023/12/6 11:07
 */
public interface Application {
    void broadcastEvent(Event event);
}
