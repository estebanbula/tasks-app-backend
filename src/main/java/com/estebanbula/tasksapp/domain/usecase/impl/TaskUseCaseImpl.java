package com.estebanbula.tasksapp.domain.usecase.impl;

import com.estebanbula.tasksapp.application.mapper.TaskMapper;
import com.estebanbula.tasksapp.domain.model.Task;
import com.estebanbula.tasksapp.domain.usecase.TaskUseCase;
import com.estebanbula.tasksapp.infraestructure.persistence.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskUseCaseImpl implements TaskUseCase {

    private final TaskRepository repository;

    @Override
    public Optional<List<Task>> retrieveTask(String state) {
        return repository.findByState(state)
                .map(taskDocuments -> {
                    List<Task> taskList = new ArrayList<>();
                    taskDocuments.forEach(document -> taskList.add(TaskMapper.toDomain(document)));
                    return taskList;
                });
    }

    @Override
    public Task saveTask(Task task) {
        return TaskMapper.toDomain(repository.save(TaskMapper.toDocument(task)));
    }

    @Override
    public Task deleteTask(String id) {
        return repository.findById(id)
                .map(currentTask -> {
                    currentTask.setState("D");
                    return currentTask;
                })
                .map(repository::save)
                .map(TaskMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public Task editTask(String id, Task task) {
        return repository.findById(id)
                .map(currentTask -> {
                    currentTask.setTitle(task.getTitle());
                    currentTask.setDetail(task.getDetail());
                    return currentTask;
                })
                .map(repository::save)
                .map(TaskMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public Task getById(String id) {
        return repository.findById(id)
                .map(TaskMapper::toDomain)
                .orElseThrow();
    }
}
