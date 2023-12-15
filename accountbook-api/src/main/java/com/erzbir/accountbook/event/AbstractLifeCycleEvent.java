package com.erzbir.accountbook.event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public abstract class AbstractLifeCycleEvent implements LifeCycleEvent {
    protected Object source;
    protected long timestamp;

    public AbstractLifeCycleEvent(Object source) {
        this.source = source;
        timestamp = System.currentTimeMillis();
    }

    @Override
    public long timestamp() {
        return timestamp;
    }

}
