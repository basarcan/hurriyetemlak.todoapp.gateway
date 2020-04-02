package com.hurriyetemlak.todoapp.gateway.converter;

import com.hurriyetemlak.todoapp.gateway.model.*;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {
    public TaskListAddRequest convertToTaskListAddRequest(TaskAddRequest taskAddRequest, String userId) {
        TaskListAddRequest taskListAddRequest = new TaskListAddRequest();
        taskListAddRequest.setTaskContent(taskAddRequest.getTaskContent());
        taskListAddRequest.setTaskFavorite(taskAddRequest.getTaskFavorite());
        taskListAddRequest.setTaskPriority(taskAddRequest.getTaskPriority());
        taskListAddRequest.setTaskSubject(taskAddRequest.getTaskSubject());
        taskListAddRequest.setTaskTitle(taskAddRequest.getTaskTitle());
        taskListAddRequest.setTaskType(taskAddRequest.getTaskType());
        taskListAddRequest.setUserId(userId);

        return taskListAddRequest;
    }

    public TaskListUpdateRequest convertToTaskListUpdateRequest(TaskUpdateRequest taskUpdateRequest, String userId) {
        TaskListUpdateRequest taskListUpdateRequest = new TaskListUpdateRequest();
        taskListUpdateRequest.setTaskContent(taskUpdateRequest.getTaskContent());
        taskListUpdateRequest.setTaskFavorite(taskUpdateRequest.getTaskFavorite());
        taskListUpdateRequest.setTaskPriority(taskUpdateRequest.getTaskPriority());
        taskListUpdateRequest.setTaskSubject(taskUpdateRequest.getTaskSubject());
        taskListUpdateRequest.setTaskTitle(taskUpdateRequest.getTaskTitle());
        taskListUpdateRequest.setTaskType(taskUpdateRequest.getTaskType());
        taskListUpdateRequest.setId(taskUpdateRequest.getId());
        taskListUpdateRequest.setUserId(userId);
        return taskListUpdateRequest;
    }

    public TaskListDeleteItemRequest convertToTaskListDeleteRequest(TaskDeleteRequest taskDeleteRequest, String userId) {
        TaskListDeleteItemRequest taskListDeleteItemRequest = new TaskListDeleteItemRequest();
        taskListDeleteItemRequest.setId(userId);
        return taskListDeleteItemRequest;
    }
}
