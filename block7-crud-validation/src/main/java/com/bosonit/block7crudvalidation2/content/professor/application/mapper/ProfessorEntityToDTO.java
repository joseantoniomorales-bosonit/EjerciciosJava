package com.bosonit.block7crudvalidation2.content.professor.application.mapper;

import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonEntityToDTO;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;

import java.util.ArrayList;
import java.util.List;

public class ProfessorEntityToDTO {
    public static ProfessorOutputDTO iniProfessorDTO(ProfessorEntity professor){
        ProfessorOutputDTO professorDTO = new ProfessorOutputDTO();

        professorDTO.setId_profesor(professor.getId_profesor());
        professorDTO.setComments(professor.getComments());
        professorDTO.setBranch(professor.getBranch());
        professorDTO.setPerson(PersonEntityToDTO.iniPersonDTO(professor.getPerson()));

        return professorDTO;
    }

    public static List<ProfessorOutputDTO> iniProfessorDTO(List<ProfessorEntity> professor){
        List<ProfessorOutputDTO> ProfessorOutputDTO = new ArrayList<>();

        for(ProfessorEntity i : professor){
            ProfessorOutputDTO.add(iniProfessorDTO(i));
        }

        return ProfessorOutputDTO;
    }
}
