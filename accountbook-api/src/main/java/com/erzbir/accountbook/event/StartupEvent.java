package com.erzbir.accountbook.event;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class StartupEvent extends AbstractLifeCycleEvent {
    public StartupEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return source;
    }
}
