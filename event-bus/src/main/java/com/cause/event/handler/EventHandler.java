package com.cause.event.handler;

import com.cause.event.listener.EventListener;
import com.cause.event.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.greenrobot.eventbus.EventBus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
@Slf4j
public class EventHandler {

    @Resource
    private EventBus eventBus;

    @Resource
    private EventListener eventListener;

    @PostConstruct
    public void init() {
        eventBus.register(eventListener);
    }

    @PreDestroy
    public void destroy() {
        eventBus.unregister(eventListener);
    }

    public void eventPost(Message message) {
        eventBus.post(message);
        log.info("post event:{}", message.toString());
    }
}
