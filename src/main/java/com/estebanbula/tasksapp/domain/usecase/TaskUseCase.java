package com.estebanbula.tasksapp.domain.usecase;

import com.estebanbula.tasksapp.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskUseCase {

   Optional<List<Task>> retrieveTask(String state);

   Task saveTask(Task task);
}
