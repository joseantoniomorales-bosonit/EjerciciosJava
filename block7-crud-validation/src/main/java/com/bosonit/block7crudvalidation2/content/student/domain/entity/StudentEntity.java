package com.bosonit.block7crudvalidation2.content.student.domain.entity;

import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import com.bosonit.block7crudvalidation2.content.professor.domain.entity.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.studies.domain.entity.StudiesEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="estudiantes")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "horas_por_semana")
    private Integer num_hours_week;

    @Column(name = "comentarios")
    private String coments;
    @Column(name = "rama")
    private String branch;

    @OneToOne
    private PersonEntity person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private ProfessorEntity professor;
   /* @OneToMany
    private List<StudiesEntity> studies;*/
}
