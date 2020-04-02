package com.hurriyetemlak.todoapp.gateway.client;

import com.hurriyetemlak.todoapp.gateway.configuration.ClientConfiguration;
import com.hurriyetemlak.todoapp.gateway.model.TaskAddRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskDeleteRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.gateway.model.TaskUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(
        value = "taskClient",
        url = "${task.client.url}",
        configuration = ClientConfiguration.class
)
public interface TaskClient {
    void updateTask(TaskUpdateRequest taskUpdateRequest);

    void addTask(TaskAddRequest taskAddRequest);

    void deleteTask(TaskDeleteRequest taskDeleteRequest);

    List<TaskListGetUserListsResponse> getTaskLists(String userId);
}
