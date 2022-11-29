package com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto;

import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseOutputDTO {
    private Integer id;

   /* private ProfessorEntity professor;
    private StudentEntity student;*/

    private String name;
    private String comment;

    private LocalDate initial_date;
    private LocalDate finish_date;
}
