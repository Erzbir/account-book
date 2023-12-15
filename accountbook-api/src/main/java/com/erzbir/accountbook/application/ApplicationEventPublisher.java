package com.erzbir.accountbook.application;

import com.erzbir.accountbook.event.LifeCycleEvent;
import com.erzbir.accountbook.event.LifeCycleListener;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface ApplicationEventPublisher {
    void publishEvent(LifeCycleEvent event);

    class LifeCycleListenerRegistry {
        public final LifeCycleListener listener;
        public final Class<? extends LifeCycleEvent> eventType;

        public LifeCycleListenerRegistry(LifeCycleListener<? extends LifeCycleEvent> listener, Class<? extends LifeCycleEvent> eventType) {
            this.eventType = eventType;
            this.listener = listener;
        }
    }
}
