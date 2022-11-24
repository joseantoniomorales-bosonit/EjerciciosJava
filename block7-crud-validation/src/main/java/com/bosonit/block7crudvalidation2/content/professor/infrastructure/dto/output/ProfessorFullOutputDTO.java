package com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output;

import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProfessorFullOutputDTO implements Serializable {

    private Integer id_profesor;

    private String comments;
    private String branch;

    private int id_person;

    private String username;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private String img_url;

    private boolean active;

    private LocalDate created_date;
    private LocalDate termination_date;

    public ProfessorFullOutputDTO(ProfessorEntity professorEntity) {
        this.id_profesor = professorEntity.getId_profesor();
        this.comments = professorEntity.getComments();
        this.branch = professorEntity.getBranch();
    }
}
