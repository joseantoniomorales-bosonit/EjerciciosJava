package com.bosonit.block7crudvalidation2.content.person.application.service;

import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import org.springframework.http.ResponseEntity;

public interface PersonService {
    public PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception;
    public ResponseEntity<Object> modifyPerson(int id_persona, PersonInputDTO personModDTO) throws Exception;
    public ResponseEntity<Object> deletePerson(int id);
}
