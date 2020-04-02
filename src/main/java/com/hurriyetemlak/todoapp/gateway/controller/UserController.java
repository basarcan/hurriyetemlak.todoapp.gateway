package com.hurriyetemlak.todoapp.gateway.controller;

import com.hurriyetemlak.todoapp.gateway.model.SignInRequest;
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

    @PostMapping(value = "sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUpRequestModel signUpRequestModel){
        userService.signUp(signUpRequestModel);
    }

    @PostMapping(value = "sign-in")
    public void signIn(@RequestBody SignInRequest signInRequest){
        userService.signIn(signInRequest);
    }

    @GetMapping(value = "verify")
    public String signUp(@RequestParam String token) {
        return userService.verify(token);
    }
}
