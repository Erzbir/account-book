package com.erzbir.event;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Erzbir
 * @Data: 2023/12/6 10:51
 */
public class EventListeners implements ListenerManager, ListenerContainer {

    private final Vector<ListenerRegistrar> listeners = new Vector<>();
    private final ExecutorService listenerExecutor = Executors.newCachedThreadPool();

    @Override
    public Vector<ListenerRegistrar> getListeners() {
        return listeners;
    }

    @Override
    public void addListener(ListenerRegistrar listenerRegistrar) {
        listeners.add(listenerRegistrar);
    }

    private <E extends Event> void addListener(Listener<E> listener, Class<? extends E> eventType) {
        listeners.add(new ListenerRegistrar(listener, eventType));
    }

    @Override
    public <E extends Event> void register(Listener<E> listener, Class<? extends E> eventType) {
        addListener(listener, eventType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends Event> void fireEvent(E event) {
        for (int i = 0; i < listeners.size(); i++) {
            ListenerRegistrar listenerRegistrar = listeners.get(i);
            if (listenerRegistrar.eventType.isInstance(event)) {
                if (event.isIntercepted()) return;
                event.intercepted();
                final int finalI = i;
                listenerExecutor.submit(() -> {
                    if (listenerRegistrar.listener.onEvent(event).equals(Listener.ListenerStatus.STOPPED)) {
                        listeners.remove(finalI);
                    }
                });
            }
        }
    }
}
