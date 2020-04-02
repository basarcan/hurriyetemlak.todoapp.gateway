package com.hurriyetemlak.todoapp.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListGetUserListsRequest {
    private String userId;
}
