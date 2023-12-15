package com.erzbir.event;


import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Erzbir
 * @Data: 2023/12/6 10:46
 */
public abstract class EventChannel<E extends Event> {
    protected Class<E> baseEventClass;

    public EventChannel(Class<E> baseEventClass) {
        this.baseEventClass = baseEventClass;
    }

    public Class<E> getBaseEventClass() {
        return baseEventClass;
    }

    public abstract E broadcast(E event);

    public abstract void registerListener(Class<? extends E> eventType, Listener<E> listener);

    public abstract <T extends E> Listener<E> subscribe(Class<T> eventType, Function<T, Listener.ListenerStatus> handle);

    public abstract <T extends E> Listener<E> createListener(Function<T, Listener.ListenerStatus> handle);

    public abstract EventChannel<E> filter(Predicate<E> predicate);
}
