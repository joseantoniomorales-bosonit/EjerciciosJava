package com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output;

import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProfessorOutputDTO implements Serializable {

    private Integer id_profesor;

    private String comments;
    private String branch;

    private PersonOutputDTO person;
}
