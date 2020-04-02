package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.UserClient;
import com.hurriyetemlak.todoapp.gateway.model.SignUpRequestModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserClient userClient;

    @Test
    public void it_should_sign_up() {
        //given
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel();
        signUpRequestModel.setEmail("email@email.com");
        signUpRequestModel.setPassword("password");
        signUpRequestModel.setFirstName("firstName");
        signUpRequestModel.setFirstName("lastName");

        //when
        userService.signUp(signUpRequestModel);

        //then
        ArgumentCaptor<SignUpRequestModel> signUpRequestModelArgumentCaptor = ArgumentCaptor.forClass(SignUpRequestModel.class);
        verify(userClient).signUp(signUpRequestModelArgumentCaptor.capture());
        SignUpRequestModel signUpRequestModelArgumentCaptorValue = signUpRequestModelArgumentCaptor.getValue();
        assertThat(signUpRequestModelArgumentCaptorValue.getEmail()).isEqualTo("email@email.com");
        assertThat(signUpRequestModelArgumentCaptorValue.getPassword()).isEqualTo("password");
        assertThat(signUpRequestModelArgumentCaptorValue.getFirstName()).isEqualTo("firstName");
        assertThat(signUpRequestModelArgumentCaptorValue.getLastName()).isEqualTo("lastName");
    }
}