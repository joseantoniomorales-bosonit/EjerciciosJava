package com.bosonit.block7crudvalidation2.content.student.infrastructure.dto;

import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import lombok.Data;

@Data
public class StudentInputDTO {
    private Integer id;
    private Integer num_hours_week;

    private String coments;
    private String branch;

    private PersonInputDTO person;

    private ProfessorInputDTO professor;

    //private List<StudiesEntity> studies;
}
