package com.hurriyetemlak.todoapp.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListGetUserListsResponse {
    private String taskId;
    private String taskTitle;
    private Boolean taskFavorite;
}
