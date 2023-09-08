package com.cause.event;

import com.cause.event.handler.EventHandler;
import com.cause.event.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventBusTest {

    @Resource
    private EventHandler eventHandler;

    @Test
    public void postEvent() {
        Message message = new Message();
        message.setType("type1");
        message.setOrderId("123123");
        message.setData("data13123");
        eventHandler.eventPost(message);
    }

}