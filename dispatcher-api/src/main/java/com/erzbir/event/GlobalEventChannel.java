package com.erzbir.event;

import java.util.ServiceLoader;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Erzbir
 * @Data: 2023/12/6 11:09
 */
public class GlobalEventChannel extends EventChannel<Event> {
    public static GlobalEventChannel INSTANCE = new GlobalEventChannel(Event.class);
    private final EventChannel<Event> delegate;

    private GlobalEventChannel(Class<Event> baseEventClass) {
        super(baseEventClass);
        delegate = ServiceLoader.load(InternalGlobalEventProvider.class)
                .findFirst()
                .orElseThrow()
                .getInstance();
    }

    @Override
    public Event broadcast(Event event) {
        return delegate.broadcast(event);
    }

    @Override
    public void registerListener(Class<? extends Event> eventType, Listener<Event> listener) {
        delegate.registerListener(eventType, listener);
    }

    @Override
    public <T extends Event> Listener<Event> subscribe(Class<T> eventType, Function<T, Listener.ListenerStatus> handle) {
        return delegate.subscribe(eventType, handle);
    }

    @Override
    public <T extends Event> Listener<Event> createListener(Function<T, Listener.ListenerStatus> handle) {
        return delegate.createListener(handle);
    }

    @Override
    public EventChannel<Event> filter(Predicate<Event> predicate) {
        return delegate.filter(predicate);
    }
}


