package com.cause.event.service;

import com.cause.event.model.MyApplicationEvent;
import com.cause.event.model.MySpringBootEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService  implements ApplicationEventPublisherAware {

    @Resource
    ApplicationEventPublisher applicationEventPublisher;

    public void saveUser() throws InterruptedException {
        log.info("save user");

        MyApplicationEvent myApplicationEvent = MyApplicationEvent.builder()
                .id("1231").name("adasdad").build();
        applicationEventPublisher.publishEvent(myApplicationEvent);

        applicationEventPublisher.publishEvent(new MySpringBootEvent("123123123123"));

        log.info("send email");

        Thread.sleep(5000);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
