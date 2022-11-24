package com.bosonit.block7crudvalidation2.content.professor.application.mapper;

import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonEntityToDTO;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorFullOutputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorEntityToDTO {
    public static ProfessorOutputDTO iniProfessorDTO(ProfessorEntity professor){
        ProfessorOutputDTO professorDTO = new ProfessorOutputDTO();

        professorDTO.setId_profesor(professor.getId_profesor());
        professorDTO.setComments(professor.getComments());
        professorDTO.setBranch(professor.getBranch());
        professorDTO.setPerson(PersonEntityToDTO.iniPersonDTO(professor.getPerson()));

        return professorDTO;
    }

    public static ProfessorFullOutputDTO iniProfessorFullDTO(ProfessorEntity professor){
        ProfessorFullOutputDTO professorDTO = new ProfessorFullOutputDTO();

        professorDTO.setId_profesor(professor.getId_profesor());
        professorDTO.setComments(professor.getComments());
        professorDTO.setBranch(professor.getBranch());

        professorDTO.setId_person(professor.getPerson().getId_person());
        professorDTO.setUsername(professor.getPerson().getUsername());
        professorDTO.setPassword(professor.getPerson().getPassword());
        professorDTO.setName(professor.getPerson().getName());
        professorDTO.setSurname(professor.getPerson().getSurname());
        professorDTO.setCompany_email(professor.getPerson().getCompany_email());
        professorDTO.setPersonal_email(professor.getPerson().getPersonal_email());
        professorDTO.setCity(professor.getPerson().getCity());
        professorDTO.setImg_url(professor.getPerson().getImg_url());
        professorDTO.setActive(professor.getPerson().isActive());
        professorDTO.setCreated_date(professor.getPerson().getCreated_date());
        professorDTO.setTermination_date(professor.getPerson().getTermination_date());

        return professorDTO;
    }

    public static List<ProfessorOutputDTO> iniProfessorDTO(List<ProfessorEntity> professor){
        return professor.stream().map(ProfessorEntityToDTO::iniProfessorDTO).collect(Collectors.toList());
    }

    public static List<ProfessorFullOutputDTO> iniProfessorFullDTO(List<ProfessorEntity> professor){
        return professor.stream().map(ProfessorEntityToDTO::iniProfessorFullDTO).collect(Collectors.toList());
    }
}
