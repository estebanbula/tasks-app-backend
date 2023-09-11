package com.estebanbula.tasksapp.application.handler.impl;

import com.estebanbula.tasksapp.application.handler.TaskHandler;
import com.estebanbula.tasksapp.domain.model.Task;
import com.estebanbula.tasksapp.domain.usecase.TaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class TaskHandlerImpl implements TaskHandler {

    private final TaskUseCase useCase;

    @Override
    public List<Task> retrieveTasksByState(String state) {
        return useCase.retrieveTask(state).orElseThrow();
    }

    @Override
    public Task saveTask(Task task) {
        return useCase.saveTask(task);
    }

    @Override
    public Task deleteTask(String id) {
        return useCase.deleteTask(id);
    }

    @Override
    public Task editTask(String id, Task task) {
        return useCase.editTask(id, task);
    }

    @Override
    public Task getTaskById(String id) {
        return useCase.getById(id);
    }
}
