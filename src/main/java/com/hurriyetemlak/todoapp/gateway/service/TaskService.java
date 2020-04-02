package com.hurriyetemlak.todoapp.gateway.service;

import com.hurriyetemlak.todoapp.gateway.client.TaskClient;
import com.hurriyetemlak.todoapp.gateway.model.TaskAddRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskDeleteRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.gateway.model.TaskUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskClient taskClient;

    public TaskService(TaskClient taskClient) {
        this.taskClient = taskClient;
    }

    public void addToList(TaskAddRequest taskAddRequest) {
        taskClient.addTask(taskAddRequest);
    }

    public void updateToList(TaskUpdateRequest taskUpdateRequest) {
            taskClient.updateTask(taskUpdateRequest);
    }

    public void deleteFromList(TaskDeleteRequest taskDeleteRequest) {
            taskClient.deleteTask(taskDeleteRequest);
    }

    public List<TaskListGetUserListsResponse> getTaskLists(String userId) {
        return taskClient.getTaskLists(userId);
    }
}
