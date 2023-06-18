package com.cause.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:urule-console-context.xml")
public class UruleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UruleDemoApplication.class, args);
    }

}
