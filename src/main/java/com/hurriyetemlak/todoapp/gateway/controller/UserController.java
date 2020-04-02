package com.hurriyetemlak.todoapp.gateway.controller;

import com.hurriyetemlak.todoapp.gateway.model.SignUpRequestModel;
import com.hurriyetemlak.todoapp.gateway.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUpRequestModel signUpRequestModel){
        userService.signUp(signUpRequestModel);
    }
}
