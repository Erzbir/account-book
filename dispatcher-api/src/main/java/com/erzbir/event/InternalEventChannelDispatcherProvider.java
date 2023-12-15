package com.erzbir.event;

/**
 * @author Erzbir
 * @Data: 2023/12/12 16:15
 */
public interface InternalEventChannelDispatcherProvider {
    EventChannel<Event> getInstance();
}
