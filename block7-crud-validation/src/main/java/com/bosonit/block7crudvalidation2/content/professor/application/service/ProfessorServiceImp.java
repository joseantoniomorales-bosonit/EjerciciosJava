package com.bosonit.block7crudvalidation2.content.professor.application.service;


import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.domain.repository.PersonRepository;
import com.bosonit.block7crudvalidation2.content.professor.application.mapper.ProfessorDTOToEntity;
import com.bosonit.block7crudvalidation2.content.professor.application.mapper.ProfessorEntityToDTO;
import com.bosonit.block7crudvalidation2.content.professor.domain.entity.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.domain.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImp implements ProfessorService{
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    PersonRepository personRepository;

    public List<ProfessorOutputDTO> getAll(){
        return ProfessorEntityToDTO.iniProfessorDTO(professorRepository.findAll());
    }

    public ResponseEntity<Object> findById(int id_profesor){
        Optional<ProfessorEntity> professor = professorRepository.findById(id_profesor);

        if(professor.isPresent()){
            return ResponseEntity.ok().body(ProfessorEntityToDTO.iniProfessorDTO(professor.get()));
        }

        return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> createProfessor(ProfessorInputDTO professor) throws Exception{
        try{
            //Si el objeto persona es null mando un responseEntity con un body avisando de que el campo id de persona no puede estar vacio
            Optional<PersonEntity> person = personRepository.findById(professor.getPerson().getId_person());
            if(person.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Person)").toString()); }

            professorValidation(professor);//Validacion

            professor.setPerson(person.get());
            ProfessorEntity professorEntity = ProfessorDTOToEntity.iniProfessorEntity(professor);

            professorRepository.save(professorEntity);

            return ResponseEntity.ok().body(ProfessorEntityToDTO.iniProfessorDTO(professorEntity));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public ResponseEntity<Object> modifyProfessor(int id, ProfessorInputDTO professorInputDTO) throws Exception{
        Optional<ProfessorEntity> professorOptional = professorRepository.findById(id);
        Optional<PersonEntity> person = personRepository.findById(professorInputDTO.getPerson().getId_person());

        if(professorOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Professor ID)")); }
        if(person.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Person ID)")); }

        professorValidation(professorInputDTO);

        ProfessorEntity professorMod = ProfessorDTOToEntity.iniProfessorEntity(professorInputDTO);
        professorMod.setId_profesor(professorOptional.get().getId_profesor());
        professorMod.setPerson(person.get());
        professorRepository.save(professorMod);

        return ResponseEntity.ok().body(professorMod);
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> deleteProfessor(int id_professor) throws Exception{
        try{
            Optional<ProfessorEntity> professor = professorRepository.findById(id_professor);

            if(professor.isPresent()){
                professorRepository.delete(professor.get());
                return ResponseEntity.ok().body("Row deleted successfully");
            }

            return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException"));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public void professorValidation(ProfessorInputDTO professor) throws Exception {
        if(professor.getBranch() == null){ throw new Exception("Branch field cannot be null"); }
        if(professor.getPerson().getId_person() == null){ throw new Exception("id_person field cannot be null"); }
    }
}
