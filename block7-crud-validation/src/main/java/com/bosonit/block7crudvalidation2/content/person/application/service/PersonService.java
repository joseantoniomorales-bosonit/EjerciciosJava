package com.bosonit.block7crudvalidation2.content.person.application.service;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Object> getAll(String outputType);
    ResponseEntity<Object> findById(int id_person, String outputType);
    PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception;
    ResponseEntity<Object> modifyPerson(int id_persona, PersonInputDTO personModDTO) throws Exception;
    ResponseEntity<Object> deletePerson(int id);
}
