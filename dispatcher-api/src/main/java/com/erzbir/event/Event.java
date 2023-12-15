package com.erzbir.event;

import java.util.concurrent.locks.Lock;

/**
 * @author Erzbir
 * @Data: 2023/12/6 10:46
 */
public interface Event {
    long timestamp();

    Object getSource();

    boolean isIntercepted();

    void intercepted();

    Lock getBroadCastLock();
}
