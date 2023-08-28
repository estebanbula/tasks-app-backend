package com.estebanbula.tasksapp.infraestructure.persistence.repository;

import com.estebanbula.tasksapp.infraestructure.persistence.document.TaskDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<TaskDocument, String> {

    Optional<List<TaskDocument>> findByState(String state);
}
