package com.bosonit.block7crudvalidation2.content.student.infrastructure.dto;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentInputDTO {
    private Integer id;
    private Integer num_hours_week;

    private String comments;
    private String branch;

    private PersonInputDTO person;

    private ProfessorInputDTO professor;

    private List<CourseEntity> course;
}
