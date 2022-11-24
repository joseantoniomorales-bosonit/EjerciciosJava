package com.bosonit.block7crudvalidation2.content.person.application.mapper;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PersonEntityToDTO {
    public static PersonOutputDTO iniPersonDTO(PersonEntity person){
        PersonOutputDTO personDTO = new PersonOutputDTO();

        personDTO.setId_person(person.getId_person());
        personDTO.setUsername(person.getUsername());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setCompany_email(person.getCompany_email());
        personDTO.setPersonal_email(person.getPersonal_email());
        personDTO.setCity(person.getCity());
        personDTO.setImg_url(person.getImg_url());
        personDTO.setCreated_date(person.getCreated_date());
        personDTO.setTermination_date(person.getTermination_date());

        return personDTO;
    }

    public static List<PersonOutputDTO> iniPersonDTO(List<PersonEntity> person){
        return person.stream().map(PersonEntityToDTO::iniPersonDTO).collect(Collectors.toList());
    }
}
