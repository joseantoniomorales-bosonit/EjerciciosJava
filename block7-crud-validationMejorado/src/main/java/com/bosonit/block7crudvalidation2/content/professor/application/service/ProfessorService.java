package com.bosonit.block7crudvalidation2.content.professor.application.service;

import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfessorService {
    List<ProfessorOutputDTO> getAll();
    ResponseEntity<Object> createProfessor(ProfessorInputDTO professor) throws Exception;
    ResponseEntity<Object> deleteProfessor(int id_profesor) throws Exception;

    void professorValidation(ProfessorInputDTO professor) throws Exception;
}
