package com.hurriyetemlak.todoapp.gateway.controller;

import com.hurriyetemlak.todoapp.gateway.model.SignUpRequestModel;
import com.hurriyetemlak.todoapp.gateway.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void it_should_sign_up() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(post("/user").contentType("application/json").content("{\n" +
                "  \"name\":\"firstName\",\n" +
                "  \"lastName\": \"lastName\",\n" +
                "  \"email\": \"email@email.com\",\n" +
                "  \"password\": \"password\"\n" +
                "}"));

        //then
        resultActions.andExpect(status().isCreated());
        verify(userService).signUp(any(SignUpRequestModel.class));
    }
}