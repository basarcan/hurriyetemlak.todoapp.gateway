package com.hurriyetemlak.todoapp.gateway.configuration;

import feign.Request;
import org.springframework.context.annotation.Bean;

public class UserClientConfiguration {
    private static final int CONNECT_TIMEOUT_MILLIS = 2000;
    private static final int READ_TIMEOUT_MILLIS = 2000;

    @Bean
    public DefaultErrorDecoder cmsApiClientErrorDecoder() {
        return new DefaultErrorDecoder();
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIMEOUT_MILLIS, READ_TIMEOUT_MILLIS);
    }
}
