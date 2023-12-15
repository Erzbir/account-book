package com.erzbir.event;


import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Erzbir
 * @Data: 2023/12/6 13:39
 */
public class EventChannelImpl<E extends Event> extends EventChannel<E> {
    protected ListenerContainer eventListeners = new EventListeners();

    public EventChannelImpl(Class<E> baseEventClass) {
        super(baseEventClass);
    }


    @Override
    public E broadcast(E event) {
        if (!(event instanceof AbstractEvent)) throw new IllegalArgumentException("Event must extend AbstractEvent");
        CompletableFuture.runAsync(() -> {
            event.getBroadCastLock().lock();
            eventListeners.fireEvent(event);
            event.getBroadCastLock().unlock();
        });
        return event;
    }

    @Override
    public void registerListener(Class<? extends E> eventType, Listener<E> listener) {
        eventListeners.addListener(new ListenerContainer.ListenerRegistrar(listener, eventType));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends E> Listener<E> subscribe(Class<T> eventType, Function<T, Listener.ListenerStatus> handle) {
        Listener<E> listener = createListener((Function<E, Listener.ListenerStatus>) handle);
        eventListeners.addListener(new ListenerContainer.ListenerRegistrar(listener, eventType));
        return listener;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends E> Listener<E> createListener(Function<T, Listener.ListenerStatus> handle) {
        return (event) -> handle.apply((T) event);
    }


    @Override
    public EventChannel<E> filter(Predicate<E> predicate) {
        return new FilterEventChannel<>(this, predicate);
    }


}
