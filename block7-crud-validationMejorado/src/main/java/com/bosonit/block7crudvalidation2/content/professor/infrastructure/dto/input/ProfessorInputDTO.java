package com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input;

import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProfessorInputDTO implements Serializable {

    private Integer id_profesor;

    private String comments;
    private String branch;

    private PersonEntity person;
}
