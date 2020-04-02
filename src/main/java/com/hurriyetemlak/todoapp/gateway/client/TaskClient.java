package com.hurriyetemlak.todoapp.gateway.client;

import com.hurriyetemlak.todoapp.gateway.configuration.ClientConfiguration;
import com.hurriyetemlak.todoapp.gateway.model.TaskListAddRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.gateway.model.TaskListUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value = "taskClient",
        url = "${task.client.url}",
        configuration = ClientConfiguration.class
)
public interface TaskClient {
    @PostMapping(value = "task")
    void addTask(TaskListAddRequest taskAddRequest);

    @PutMapping(value = "task")
    void updateTask(TaskListUpdateRequest taskUpdateRequest);

    @DeleteMapping(value = "task")
    void deleteTask(TaskListDeleteItemRequest taskDeleteRequest);

    @GetMapping(value = "task")
    List<TaskListGetUserListsResponse> getTaskLists(@RequestParam String userId);
}
