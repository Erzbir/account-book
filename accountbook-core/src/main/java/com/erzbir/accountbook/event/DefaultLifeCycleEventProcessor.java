package com.erzbir.accountbook.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultLifeCycleEventProcessor implements LifeCycleEventProcessor {
    List<LifeCycleListener> listeners = new ArrayList<>();

    @Override
    public void fireEvent(LifeCycleEvent lifeCycleEvent) {
        for (int i = 0; i < listeners.size(); i++) {
            LifeCycleListener lifeCycleListener = listeners.get(i);
            lifeCycleListener.onEvent(lifeCycleEvent);
        }
    }

    @Override
    public List<LifeCycleListener> getListenerContainer() {
        return null;
    }
}
