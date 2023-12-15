package com.erzbir.context;


import com.erzbir.event.Event;
import com.erzbir.event.EventChannelDispatcher;

/**
 * @author Erzbir
 * @Data: 2023/12/6 11:13
 */
public class InternalDefaultApplication implements Application {


    public InternalDefaultApplication() {
    }


    @Override
    public void broadcastEvent(Event event) {
        EventChannelDispatcher.INSTANCE.broadcast(event);
    }
}
