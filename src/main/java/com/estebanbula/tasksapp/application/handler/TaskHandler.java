package com.estebanbula.tasksapp.application.handler;

import com.estebanbula.tasksapp.domain.model.Task;

import java.util.List;

public interface TaskHandler {

    List<Task> retrieveTasksByState(String state);

    Task saveTask(Task task);
}
