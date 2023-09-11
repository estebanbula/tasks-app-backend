package com.estebanbula.tasksapp.application.handler;

import com.estebanbula.tasksapp.domain.model.Task;

import java.util.List;

public interface TaskHandler {

    List<Task> retrieveTasksByState(String state);
    Task saveTask(Task task);
    Task deleteTask(String id);
    Task editTask(String id, Task task);
    Task getTaskById(String id);
}
