package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.UserClient;
import com.hurriyetemlak.todoapp.gateway.model.SignInRequest;
import com.hurriyetemlak.todoapp.gateway.model.SignInResponse;
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

    public SignInResponse signIn(SignInRequest signInRequest) {
        return userClient.signIn(signInRequest);
    }

    public String verify(String token) {
        return null;
    }
}
