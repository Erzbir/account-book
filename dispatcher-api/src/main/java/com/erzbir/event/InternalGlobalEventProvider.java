package com.erzbir.event;

/**
 * @author Erzbir
 * @Data: 2023/12/12 15:29
 */
public interface InternalGlobalEventProvider {
    EventChannel<Event> getInstance();
}
