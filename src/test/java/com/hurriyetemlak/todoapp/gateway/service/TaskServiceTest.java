package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.TaskClient;
import com.hurriyetemlak.todoapp.gateway.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskClient taskClient;


    @Test
    public void it_should_add_task_to_list() {
        //given
        TaskAddRequest taskAddRequest = new TaskAddRequest();
        taskAddRequest.setToken("token");
        taskAddRequest.setTaskTitle("taskTitle");
        taskAddRequest.setTaskSubject("taskSubject");
        taskAddRequest.setTaskType("taskType");
        taskAddRequest.setTaskContent("taskContent");
        taskAddRequest.setTaskPriority((byte) 0);
        taskAddRequest.setTaskFavorite(false);


        //when
        taskService.addToList(taskAddRequest);

        //then
        verify(taskClient).addTask(any(TaskAddRequest.class));
    }

    @Test
    public void it_should_update_task_on_list() {
        //given
        TaskUpdateRequest taskUpdateRequest = new TaskUpdateRequest();
        taskUpdateRequest.setId("0");
        taskUpdateRequest.setToken("token");
        taskUpdateRequest.setTaskTitle("taskTitle");
        taskUpdateRequest.setTaskSubject("taskSubject");
        taskUpdateRequest.setTaskType("taskType");
        taskUpdateRequest.setTaskContent("taskContent");
        taskUpdateRequest.setTaskPriority((byte) 0);
        taskUpdateRequest.setTaskFavorite(false);


        //when
        taskService.updateToList(taskUpdateRequest);

        //then
        verify(taskClient).updateTask(any(TaskUpdateRequest.class));

    }

    @Test
    public void it_should_delete_from_list() {
        //given
        TaskDeleteRequest taskDeleteRequest = new TaskDeleteRequest();
        taskDeleteRequest.setToken("token");


        //when
        taskService.deleteFromList(taskDeleteRequest);

        //then
        verify(taskClient).deleteTask(any(TaskDeleteRequest.class));

    }

    @Test
    public void it_should_return_task_lists_by_user() {
        //given
        TaskListRequest taskListRequest = new TaskListRequest();
        taskListRequest.setToken("token");


        TaskListGetUserListsResponse model11 = new TaskListGetUserListsResponse();
        TaskListGetUserListsResponse model12 = new TaskListGetUserListsResponse();
        model11.setTaskId("1");
        model11.setTaskTitle("firstTitle");
        model11.setTaskFavorite(false);
        model12.setTaskId("2");
        model12.setTaskTitle("secondTitle");
        model12.setTaskFavorite(false);
        List<TaskListGetUserListsResponse> taskListGetUserListsResponseList = Arrays.asList(model11, model12);


        given(taskClient.getTaskLists("0")).willReturn(taskListGetUserListsResponseList);


        //when
        List<TaskListGetUserListsResponse> taskListGetListsResponseListUser = taskService.getTaskLists("0");

        //then
        assertThat(taskListGetListsResponseListUser.get(0).getTaskId()).isEqualTo("1");
        assertThat(taskListGetListsResponseListUser.get(0).getTaskTitle()).isEqualTo("firstTitle");
        assertThat(taskListGetListsResponseListUser.get(0).getTaskFavorite()).isEqualTo(false);

        assertThat(taskListGetListsResponseListUser.get(1).getTaskId()).isEqualTo("2");
        assertThat(taskListGetListsResponseListUser.get(1).getTaskTitle()).isEqualTo("secondTitle");
        assertThat(taskListGetListsResponseListUser.get(1).getTaskFavorite()).isEqualTo(false);
    }

}