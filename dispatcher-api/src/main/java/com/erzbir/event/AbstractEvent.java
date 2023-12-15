package com.erzbir.event;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Erzbir
 * @Data: 2023/12/6 10:47
 */
public abstract class AbstractEvent implements Event {
    private final AtomicBoolean canceled;
    protected Object source;
    protected long timestamp;
    protected boolean isIntercepted;
    protected Lock broadCastLock;

    public AbstractEvent(Object source) {
        this.source = source;
        timestamp = System.currentTimeMillis();
        broadCastLock = new ReentrantLock();
        canceled = new AtomicBoolean();
    }

    @Override
    public long timestamp() {
        return timestamp;
    }

    @Override
    public boolean isIntercepted() {
        return isIntercepted;
    }

    @Override
    public void intercepted() {
        isIntercepted = true;
    }

    public void cancel() {
        if (!(this instanceof CancelableEvent)) return;
        canceled.set(true);
    }

    public boolean isCanceled() {
        if (!(this instanceof CancelableEvent)) throw new UnsupportedOperationException();
        return canceled.get();
    }

    @Override
    public Lock getBroadCastLock() {
        return broadCastLock;
    }
}
