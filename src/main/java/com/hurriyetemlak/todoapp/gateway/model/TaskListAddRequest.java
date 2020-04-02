package com.hurriyetemlak.todoapp.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskListAddRequest {
    private String userId;
    private String taskTitle;
    private String taskSubject;
    private String taskContent;
    private byte taskPriority;
    private String taskType;
    private Boolean taskFavorite;
}
