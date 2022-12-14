package com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output;

import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProfessorOutputDTO implements Serializable {

    private Integer id_profesor;

    private String comments;
    private String branch;

    private PersonOutputDTO person;

    public ProfessorOutputDTO(ProfessorEntity professorEntity) {
        this.id_profesor = professorEntity.getId_profesor();
        this.comments = professorEntity.getComments();
        this.branch = professorEntity.getBranch();
        this.person = new PersonOutputDTO(professorEntity.getPerson());
    }
}
