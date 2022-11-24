package com.bosonit.block7crudvalidation2.content.professor.application.mapper;

import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return professor.stream().map(p-> new ProfessorEntity().fromDTO(p)).collect(Collectors.toList());
//                .        List<ProfessorEntity> professorEntity = new ArrayList<>();
//
//        for(ProfessorInputDTO i : professor){
//            professorEntity.add(iniProfessorEntity(i));
//        }
//
//        return professorEntity;
    }
}
