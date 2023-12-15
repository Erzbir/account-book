package com.erzbir.accountbook.event;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface LifeCycleEventProcessor {
    void fireEvent(LifeCycleEvent lifeCycleEvent);

    List<LifeCycleListener> getListenerContainer();
}
