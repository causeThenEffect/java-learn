package com.cause.event.listener;

import com.cause.event.model.MyApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener {

    @EventListener
    public void onApplicationEvent1(MyApplicationEvent event) {
        log.info("MyApplicationEvent1: {}, {}", event.getId(), event.getName());
    }

    @EventListener
    @Async(value = "taskExecutor")
    public void onApplicationEvent2(MyApplicationEvent event) {
//        throw new RuntimeException("onApplicationEvent2 RuntimeException");
        log.info("MyApplicationEvent2: {}, {}", event.getId(), event.getName());
    }

    @EventListener
    @Async(value = "taskExecutor")
    public void onApplicationEvent3(MyApplicationEvent event) throws InterruptedException {
        Thread.sleep(3000);
        log.info("MyApplicationEvent3: {}, {}", event.getId(), event.getName());
    }

}
