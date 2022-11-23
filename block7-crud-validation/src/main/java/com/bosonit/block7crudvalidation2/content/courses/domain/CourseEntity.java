package com.bosonit.block7crudvalidation2.content.courses.domain;

import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asignaturas")
@Data
@NoArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue
    private Integer id;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    private ProfessorEntity professor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private StudentEntity student;*/

    @Column(name = "asignatura")
    private String name;
    @Column(name = "comentarios")
    private String comment;

    @Column
    private LocalDate initial_date;
    @Column
    private LocalDate finish_date;

    public CourseEntity(String name, String comment, LocalDate initial_date) {
        this.name = name;
        this.comment = comment;
        this.initial_date = initial_date;
    }
}
