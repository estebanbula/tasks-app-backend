package com.estebanbula.tasksapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String id;
    private String title;
    private String detail;
    private String created;
    private String state;

}
