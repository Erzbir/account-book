package com.erzbir.event;


import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Erzbir
 * @Data: 2023/12/6 16:41
 */
public class FilterEventChannel<E extends Event> extends EventChannel<E> {
    private final EventChannel<E> delegate;
    private final Predicate<E> filter;

    public FilterEventChannel(EventChannel<E> delegate, Predicate<E> filter) {
        super(delegate.getBaseEventClass());
        this.delegate = delegate;
        this.filter = filter;
    }

    @Override
    public E broadcast(E event) {
        return delegate.broadcast(event);
    }

    @Override
    public void registerListener(Class<? extends E> eventType, Listener<E> listener) {
        delegate.registerListener(eventType, listener);
    }

    @Override
    public <T extends E> Listener<E> subscribe(Class<T> eventType, Function<T, Listener.ListenerStatus> handle) {
        return delegate.subscribe(eventType, intercept(handle));
    }

    @Override
    public <T extends E> Listener<E> createListener(Function<T, Listener.ListenerStatus> handle) {
        return delegate.createListener(intercept(handle));
    }

    private <T extends E> Function<T, Listener.ListenerStatus> intercept(Function<T, Listener.ListenerStatus> handle) {
        return (ev) -> {
            boolean filterResult;
            filterResult = getBaseEventClass().isInstance(ev) && filter.test(ev);
            if (filterResult) {
                return handle.apply(ev);
            } else {
                return Listener.ListenerStatus.STOPPED;
            }
        };
    }

    @Override
    public EventChannel<E> filter(Predicate<E> predicate) {
        return delegate.filter(predicate);
    }
}
