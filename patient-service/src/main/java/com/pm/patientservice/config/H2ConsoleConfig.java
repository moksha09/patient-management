package com.pm.patientservice.config;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2servletRegistration(){
        ServletRegistrationBean<JakartaWebServlet> registration =
                new ServletRegistrationBean<>(new JakartaWebServlet());

        // Map explicitly to /h2-console/*
        registration.addUrlMappings("/h2-console/*");
        return registration;
    }
}
