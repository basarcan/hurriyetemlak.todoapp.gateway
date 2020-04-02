package com.hurriyetemlak.todoapp.gateway.configuration;

import feign.Response;
import feign.codec.ErrorDecoder;

public class DefaultErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return new Default().decode(methodKey, response);
    }
}
