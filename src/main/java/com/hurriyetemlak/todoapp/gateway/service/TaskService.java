package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.TaskClient;
import com.hurriyetemlak.todoapp.gateway.converter.TaskConverter;
import com.hurriyetemlak.todoapp.gateway.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskClient taskClient;
    private final UserService userService;
    private final TaskConverter taskConverter;

    public TaskService(TaskClient taskClient, UserService userService, TaskConverter taskConverter) {
        this.taskClient = taskClient;
        this.userService = userService;
        this.taskConverter = taskConverter;
    }

    public void addToList(TaskAddRequest taskAddRequest) {
        String userId = verifyToken(taskAddRequest.getToken());
        if (!userId.isEmpty()) {
            TaskListAddRequest taskListAddRequest = taskConverter.convertToTaskListAddRequest(taskAddRequest, userId);
            taskClient.addTask(taskListAddRequest);
        }
    }

    public void updateToList(TaskUpdateRequest taskUpdateRequest) {
        String userId = verifyToken(taskUpdateRequest.getToken());
        if (!userId.isEmpty()) {
            TaskListUpdateRequest taskListUpdateRequest = taskConverter.convertToTaskListUpdateRequest(taskUpdateRequest, userId);
            taskClient.updateTask(taskListUpdateRequest);
        }
    }

    public void deleteFromList(TaskDeleteRequest taskDeleteRequest) {
        String userId = verifyToken(taskDeleteRequest.getToken());
        if (!userId.isEmpty()) {
            TaskListDeleteItemRequest taskListDeleteItemRequest = taskConverter.convertToTaskListDeleteRequest(taskDeleteRequest, userId);
            taskClient.deleteTask(taskListDeleteItemRequest);
        }
    }

    public List<TaskListGetUserListsResponse> getTaskLists(String token) {
        String userId = verifyToken(token);
        if (!userId.isEmpty()) {
            return taskClient.getTaskLists(userId);
        }
        return new ArrayList<>();
    }

    private String verifyToken(String token) {
        return userService.verify(token);
    }
}
