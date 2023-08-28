package com.estebanbula.tasksapp.infraestructure.rest;

import com.estebanbula.tasksapp.application.handler.TaskHandler;
import com.estebanbula.tasksapp.domain.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/tasks")
@RequiredArgsConstructor
public class TaskRestController {

    private final TaskHandler handler;

    @GetMapping("")
    public ResponseEntity<List<Task>> getTasksList(@RequestParam String state) {
        return new ResponseEntity<>(handler.retrieveTasksByState(state), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        return new ResponseEntity<>(handler.saveTask(task), HttpStatus.CREATED);
    }
}
