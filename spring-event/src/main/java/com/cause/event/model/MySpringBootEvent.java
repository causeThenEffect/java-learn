package com.cause.event.model;

import org.springframework.context.ApplicationEvent;

public class MySpringBootEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MySpringBootEvent(Object source) {
        super(source);
    }
}
