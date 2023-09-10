package com.estebanbula.tasksapp.infraestructure.persistence.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "task")
public class TaskDocument {

    @Id
    private String id;
    private String title;
    private String detail;
    private String created;
    private String state;
}
