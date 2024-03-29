package com.cause.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskConfig {

    /**
     * 核心线程数
     */
    private int corePoolSize = 10;
    /**
     * 最大线程数
     */
    private int maxPoolSize = 50;
    /**
     * 队列大小
     */
    private int queueCapacity = 10;
    /**
     * 线程最大空闲时间
     */
    private int keepAliveSeconds = 150;

    @Bean("taskExecutor")
    public Executor myExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setKeepAliveSeconds(keepAliveSeconds);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

//    @Bean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
//    public SimpleApplicationEventMulticaster myEventMulticaster() {
//        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
//        simpleApplicationEventMulticaster.setTaskExecutor(myExecutor());
//        return simpleApplicationEventMulticaster;
//    }

}
