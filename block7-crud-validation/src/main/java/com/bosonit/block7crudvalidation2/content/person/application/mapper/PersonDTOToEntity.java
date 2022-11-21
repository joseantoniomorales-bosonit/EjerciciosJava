package com.bosonit.block7crudvalidation2.content.person.application.mapper;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;

import java.util.ArrayList;
import java.util.List;

public class PersonDTOToEntity {
    public static PersonEntity iniPersonEntity(PersonInputDTO person){
        PersonEntity personEntity = new PersonEntity();

        personEntity.setId_person(person.getId_person());
        personEntity.setUsername(person.getUsername());
        personEntity.setPassword(person.getPassword());
        personEntity.setName(person.getName());
        personEntity.setSurname(person.getSurname());
        personEntity.setCompany_email(person.getCompany_email());
        personEntity.setPersonal_email(person.getPersonal_email());
        personEntity.setCity(person.getCity());
        personEntity.setImg_url(person.getImg_url());
        personEntity.setActive(person.isActive());
        personEntity.setCreated_date(person.getCreated_date());
        personEntity.setTermination_date(person.getTermination_date());

        return personEntity;
    }

    public static List<PersonEntity> iniPersonEntity(List<PersonInputDTO> person){
        List<PersonEntity> personEntity = new ArrayList<>();

        for(PersonInputDTO i : person){
            personEntity.add(iniPersonEntity(i));
        }

        return personEntity;
    }
}
