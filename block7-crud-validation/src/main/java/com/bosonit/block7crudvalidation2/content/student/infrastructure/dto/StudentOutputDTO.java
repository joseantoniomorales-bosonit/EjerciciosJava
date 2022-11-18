package com.bosonit.block7crudvalidation2.content.student.infrastructure.dto;

import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;
import lombok.Data;

@Data
public class StudentOutputDTO {
    private Integer id;
    private Integer num_hours_week;

    private String coments;
    private String branch;

    private PersonOutputDTO person;

    private ProfessorOutputDTO professor;

    //private List<StudiesEntity> studies;
}
