package com.estebanbula.tasksapp.application.mapper;

import com.estebanbula.tasksapp.domain.model.Task;
import com.estebanbula.tasksapp.infraestructure.persistence.document.TaskDocument;

public class TaskMapper {

    private TaskMapper() {

    }

    public static Task toDomain(TaskDocument document) {
        return Task.builder()
                .id(document.getId())
                .title(document.getTitle())
                .detail(document.getDetail())
                .created(document.getCreated())
                .state(document.getState())
                .build();
    }

    public static TaskDocument toDocument(Task model) {
        return TaskDocument.builder()
                .id(model.getId())
                .title(model.getTitle())
                .detail(model.getDetail())
                .created(model.getCreated())
                .state(model.getState())
                .build();
    }
}
