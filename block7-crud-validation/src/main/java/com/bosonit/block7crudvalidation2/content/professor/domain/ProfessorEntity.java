package com.bosonit.block7crudvalidation2.content.professor.domain;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="profesores")
@Data
@NoArgsConstructor
public class ProfessorEntity {
    @Id
    @GeneratedValue
    private Integer id_profesor;

    @Column(name="comments")
    private String comments;
    @Column(name="branch", nullable = false)
    private String branch;

    @OneToOne
    @JoinColumn(name = "id_persona")
    PersonEntity person;

    public ProfessorEntity(String comments, String branch, PersonEntity person) {
        this.comments = comments;
        this.branch = branch;
        this.person = person;
    }
    public ProfessorEntity fromDTO(ProfessorInputDTO professorInputDTO) {
        this.comments = professorInputDTO.getComments();
        this.branch = professorInputDTO.getBranch();
        this.person = professorInputDTO.getPerson();
        return this;
    }
}
