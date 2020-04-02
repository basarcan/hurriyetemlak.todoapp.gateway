package com.hurriyetemlak.todoapp.gateway.client;

import com.hurriyetemlak.todoapp.gateway.configuration.UserClientConfiguration;
import com.hurriyetemlak.todoapp.gateway.model.SignUpRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "userClient",
        url = "${user.client.url}",
        configuration = UserClientConfiguration.class
)
public interface UserClient {

    @PostMapping(value = "/sign-up")
    void signUp(@RequestBody SignUpRequestModel signUpRequestModel);
}
