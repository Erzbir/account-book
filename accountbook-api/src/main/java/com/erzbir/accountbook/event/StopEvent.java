package com.erzbir.accountbook.event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class StopEvent extends AbstractLifeCycleEvent {
    public StopEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return source;
    }

}
