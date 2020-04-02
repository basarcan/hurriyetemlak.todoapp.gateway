package com.hurriyetemlak.todoapp.gateway.controller;

import com.hurriyetemlak.todoapp.gateway.model.TaskAddRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskDeleteRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskUpdateRequest;
import com.hurriyetemlak.todoapp.gateway.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    public void it_should_add_task_to_list() throws Exception {
        //given


        //when
        ResultActions resultActions = mockMvc.perform(post("/task")
                .content("{\n" +
                        "  \"userId\": \"0\",\n" +
                        "  \"taskTitle\": \"taskTitle\",\n" +
                        "  \"taskSubject\": \"taskSubject\",\n" +
                        "  \"taskContent\": \"taskContent\",\n" +
                        "  \"priority\": 0,\n" +
                        "  \"taskType\": \"taskType\",\n" +
                        "  \"taskFavorite\": false\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON));
        //then

        resultActions.andExpect(status().isCreated());
        verify(taskService).addToList(any(TaskAddRequest.class));
    }

    @Test
    public void it_should_update_task_on_list() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(put("/task")
                .content("{\n" +
                        "  \"id\": \"0\",\n" +
                        "  \"userId\": \"0\",\n" +
                        "  \"taskTitle\": \"taskTitle\",\n" +
                        "  \"taskSubject\": \"taskSubject\",\n" +
                        "  \"taskContent\": \"taskContent\",\n" +
                        "  \"priority\": 0,\n" +
                        "  \"taskType\": \"taskType\",\n" +
                        "  \"taskFavorite\": false\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON));
        //then
        resultActions.andExpect(status().isOk());
        verify(taskService).updateToList(any(TaskUpdateRequest.class));
    }

    @Test
    public void it_should_delete_task_on_list() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(delete("/task")
                .content("{ \"id\":\"0\"}")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        resultActions.andExpect(status().isOk());
        verify(taskService).deleteFromList(any(TaskDeleteRequest.class));
    }

    @Test
    public void it_should_return_task_lists_by_user() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(get("/task?userId=0")
                .contentType(MediaType.APPLICATION_JSON));
        //then
        resultActions.andExpect(status().isOk());
        verify(taskService).getTaskLists("0");
    }

}