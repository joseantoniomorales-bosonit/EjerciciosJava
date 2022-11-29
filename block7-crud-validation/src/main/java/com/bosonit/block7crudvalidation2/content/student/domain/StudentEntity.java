package com.bosonit.block7crudvalidation2.content.student.domain;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="estudiantes")
@Data
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "horas_por_semana", nullable = false)
    private Integer num_hours_week;

    @Column(name = "comentarios")
    private String comments;
    @Column(name = "rama")
    private String branch;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private PersonEntity person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private ProfessorEntity professor;
    @OneToMany
    private List<CourseEntity> course;

    public StudentEntity(Integer num_hours_week, String comments, String branch, PersonEntity person, ProfessorEntity professor) {
        this.num_hours_week = num_hours_week;
        this.comments = comments;
        this.branch = branch;
        this.person = person;
        this.professor = professor;
    }

    public StudentEntity(Integer num_hours_week, String comments, String branch, PersonEntity person, ProfessorEntity professor, List<CourseEntity> course) {
        this.num_hours_week = num_hours_week;
        this.comments = comments;
        this.branch = branch;
        this.person = person;
        this.professor = professor;
        this.course = course;
    }
}
