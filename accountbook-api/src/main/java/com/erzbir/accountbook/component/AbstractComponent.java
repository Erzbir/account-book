package com.erzbir.accountbook.component;

import com.erzbir.context.DefaultApplication;
import com.erzbir.event.Event;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public abstract class AbstractComponent implements Component {
    protected AtomicBoolean active = new AtomicBoolean();
    protected AtomicBoolean isInit = new AtomicBoolean();
    protected com.erzbir.context.Application eventDispatcher = new DefaultApplication();


    public AbstractComponent() {
        isInit.set(false);
        active.set(true);
    }

    @Override
    public boolean isInit() {
        return isInit.get();
    }

    @Override
    public boolean isActive() {
        return active.get();
    }

    public abstract void init();

    @Override
    public void disable() {
        active.set(false);
    }

    @Override
    public void active() {
        active.set(true);
    }

    @Override
    public void broadcastEvent(Event event) {
        eventDispatcher.broadcastEvent(event);
    }
}
