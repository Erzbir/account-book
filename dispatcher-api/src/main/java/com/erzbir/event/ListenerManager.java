package com.erzbir.event;

/**
 * @author Erzbir
 * @Data: 2023/12/6 11:10
 */
public interface ListenerManager {
    <E extends Event> void register(Listener<E> listener, Class<? extends E> eventType);

    <E extends Event> void fireEvent(E event);
}
