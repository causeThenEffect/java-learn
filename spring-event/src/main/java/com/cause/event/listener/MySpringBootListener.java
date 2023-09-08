package com.cause.event.listener;

import com.cause.event.model.MySpringBootEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MySpringBootListener implements ApplicationListener<MySpringBootEvent> {

    @Override
    @Async(value = "taskExecutor")
    public void onApplicationEvent(MySpringBootEvent event) {
        log.info("event=====>{}, {}, {}", event.getClass().getName(), event.getTimestamp(), event.getSource().toString());
    }
}
