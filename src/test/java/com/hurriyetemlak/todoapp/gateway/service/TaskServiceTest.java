package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.TaskClient;
import com.hurriyetemlak.todoapp.gateway.converter.TaskConverter;
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

    @Mock
    private UserService userService;

    @Mock
    private TaskConverter taskConverter;


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
        given(userService.verify("token")).willReturn("userId");
        given(taskConverter.convertToTaskListAddRequest(taskAddRequest, "userId")).willReturn(new TaskListAddRequest());


        //when
        taskService.addToList(taskAddRequest);

        //then
        verify(taskClient).addTask(any(TaskListAddRequest.class));
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
        taskUpdateRequest.setToken("token");
        given(userService.verify("token")).willReturn("userId");
        given(taskConverter.convertToTaskListUpdateRequest(taskUpdateRequest, "userId")).willReturn(new TaskListUpdateRequest());


        //when
        taskService.updateToList(taskUpdateRequest);

        //then
        verify(taskClient).updateTask(any(TaskListUpdateRequest.class));

    }

    @Test
    public void it_should_delete_from_list() {
        //given
        TaskDeleteRequest taskDeleteRequest = new TaskDeleteRequest();
        taskDeleteRequest.setToken("token");
        given(userService.verify("token")).willReturn("userId");
        given(taskConverter.convertToTaskListDeleteRequest(taskDeleteRequest, "userId")).willReturn(new TaskListDeleteItemRequest());


        //when
        taskService.deleteFromList(taskDeleteRequest);

        //then
        verify(taskClient).deleteTask(any(TaskListDeleteItemRequest.class));

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

        given(userService.verify("token")).willReturn("userId");
        given(taskClient.getTaskLists("userId")).willReturn(taskListGetUserListsResponseList);



        //when
        List<TaskListGetUserListsResponse> taskListGetListsResponseListUser = taskService.getTaskLists("token");

        //then
        assertThat(taskListGetListsResponseListUser.get(0).getTaskId()).isEqualTo("1");
        assertThat(taskListGetListsResponseListUser.get(0).getTaskTitle()).isEqualTo("firstTitle");
        assertThat(taskListGetListsResponseListUser.get(0).getTaskFavorite()).isEqualTo(false);

        assertThat(taskListGetListsResponseListUser.get(1).getTaskId()).isEqualTo("2");
        assertThat(taskListGetListsResponseListUser.get(1).getTaskTitle()).isEqualTo("secondTitle");
        assertThat(taskListGetListsResponseListUser.get(1).getTaskFavorite()).isEqualTo(false);
    }

}