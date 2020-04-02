package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.UserClient;
import com.hurriyetemlak.todoapp.gateway.model.SignUpRequestModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public void signUp(SignUpRequestModel signUpRequestModel) {
        userClient.signUp(signUpRequestModel);
    }
}
