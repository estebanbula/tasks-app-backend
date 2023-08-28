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
}
