package com.cause.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bstek.urule.KnowledgePackageReceiverServlet;
import com.bstek.urule.console.URuleServlet;

@Configuration
public class URuleConfig {

    @Bean
    public ServletRegistrationBean registerUruleServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new URuleServlet(), "/urule/*");
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean registerKnowledgeServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new KnowledgePackageReceiverServlet(), "/knowledgepackagereceiver");
        return servletRegistrationBean;
    }

}
