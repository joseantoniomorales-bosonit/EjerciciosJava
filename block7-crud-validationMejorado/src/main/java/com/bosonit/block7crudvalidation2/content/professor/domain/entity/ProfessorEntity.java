package com.bosonit.block7crudvalidation2.content.professor.domain.entity;

import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="profesores")
@Data
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_profesor;

    @Column(name="comments")
    private String comments;
    @Column(name="branch")
    private String branch;

    @OneToOne
    @JoinColumn(name = "id_persona")
    PersonEntity person;
}
