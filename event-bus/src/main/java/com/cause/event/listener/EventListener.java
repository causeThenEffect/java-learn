package com.cause.event.listener;

import com.cause.event.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.greenrobot.eventbus.Subscribe;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventListener {

    @Subscribe
    public void onMessageEvent1(Message message) {
        log.info("Subscribe1 message:{}", message.toString());
    }

    @Subscribe
    public void onMessageEvent2(Message message) {
        log.info("Subscribe2 message:{}", message.toString());
    }

    @Subscribe
    public void onMessageEvent3(Message message) {
        log.info("Subscribe3 message:{}", message.toString());
    }

}
