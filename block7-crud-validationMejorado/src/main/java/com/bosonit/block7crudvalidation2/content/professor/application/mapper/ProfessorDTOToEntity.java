package com.bosonit.block7crudvalidation2.content.professor.application.mapper;

import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonDTOToEntity;
import com.bosonit.block7crudvalidation2.content.professor.domain.entity.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDTOToEntity {
    public static ProfessorEntity iniProfessorEntity(ProfessorInputDTO professorDTO){
        ProfessorEntity professorEntity = new ProfessorEntity();

        professorEntity.setId_profesor(professorDTO.getId_profesor());
        professorEntity.setComments(professorDTO.getComments());
        professorEntity.setBranch(professorDTO.getBranch());
        professorEntity.setPerson(professorDTO.getPerson());

        return professorEntity;
    }

    public static List<ProfessorEntity> iniProfessorEntity(List<ProfessorInputDTO> professor){
        List<ProfessorEntity> professorEntity = new ArrayList<>();

        for(ProfessorInputDTO i : professor){
            professorEntity.add(iniProfessorEntity(i));
        }

        return professorEntity;
    }
}
