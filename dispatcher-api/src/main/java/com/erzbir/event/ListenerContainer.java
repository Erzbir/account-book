package com.erzbir.event;

import java.util.Vector;

/**
 * 监听器容器
 *
 * @author Erzbir
 * @Data: 2023/12/6 11:35
 */
public interface ListenerContainer extends ListenerManager {
    Vector<ListenerRegistrar> getListeners();

    void addListener(ListenerRegistrar listenerRegistrar);

    /**
     * 监听器句柄
     */
    final class ListenerRegistrar {
        public final Listener listener;
        public final Class<Event> eventType;

        public <E extends Event> ListenerRegistrar(Listener<E> listener, Class<? extends E> eventType) {
            this.listener = listener;
            this.eventType = (Class<Event>) eventType;
        }
    }
}
