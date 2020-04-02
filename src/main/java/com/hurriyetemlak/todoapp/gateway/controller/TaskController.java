package com.hurriyetemlak.todoapp.gateway.controller;


import com.hurriyetemlak.todoapp.gateway.model.TaskAddRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskDeleteRequest;
import com.hurriyetemlak.todoapp.gateway.model.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.gateway.model.TaskUpdateRequest;
import com.hurriyetemlak.todoapp.gateway.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addToList(@RequestBody TaskAddRequest taskAddRequest) {
        taskService.addToList(taskAddRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateToList(@RequestBody TaskUpdateRequest taskUpdateRequest) {
        taskService.updateToList(taskUpdateRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteFromList(@RequestBody TaskDeleteRequest taskDeleteRequest) {
        taskService.deleteFromList(taskDeleteRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskListGetUserListsResponse> getTaskLists(@RequestParam String userId)
    {
        return taskService.getTaskLists(userId);
    }


}
