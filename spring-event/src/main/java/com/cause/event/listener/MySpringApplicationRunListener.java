package com.cause.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        System.out.println("MySpringApplicationRunListener...");
    }

    @Override
    public void starting() {
        log.error("application starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.error("environmentPrepared......{}", environment.getActiveProfiles().toString());
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.error("contextPrepared...", context.getEnvironment().getPropertySources().toString());
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.error("contextLoaded...", context.getEnvironment().getPropertySources().toString());
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.error("started...", context.getEnvironment().getPropertySources().toString());
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.error("running...", context.getEnvironment().getPropertySources().toString());
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.error("failed...", context.getEnvironment().getPropertySources().toString());
    }
}
