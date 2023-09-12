package com.cause.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 事件机制贯穿了spring框架的整个生命周期
 *
 * mybatis框架没有使用事件机制，所以导致代码有点乱
 *
 * 监听器分为两种 1 run listener 其实并不是严格的监听器，就是更像是用来生产springboot启动生命周期事件的事件源
 *              2 application listener 真正意义上的监听器，监听实现applicationEvent接口的各种事件
 */
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
