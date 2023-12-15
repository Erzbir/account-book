package com.erzbir.context;


import com.erzbir.event.Event;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @Data: 2023/12/6 11:13
 */
public class DefaultApplication implements Application {
    private final Application instance;

    public DefaultApplication() {
        instance = ServiceLoader.load(Application.class).findFirst().orElseThrow();
    }


    @Override
    public void broadcastEvent(Event event) {
        instance.broadcastEvent(event);
    }
}
