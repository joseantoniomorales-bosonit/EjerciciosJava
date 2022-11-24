package com.bosonit.block7crudvalidation2.content.person.application.service;


import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonDTOToEntity;
import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonEntityToDTO;
import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.repository.PersonRepository;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import com.bosonit.block7crudvalidation2.content.professor.application.mapper.ProfessorEntityToDTO;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation2.content.student.application.mapper.StudentEntityToDTO;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.repository.StudentRepository;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@Service
public class PersonServiceImp implements PersonService{
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    StudentRepository studentRepository;
    public List<PersonOutputDTO> getAll(){
        //DTO
        return PersonEntityToDTO.iniPersonDTO(personRepository.findAll());
    }

    public ResponseEntity<Object> findById(int id_person, String outputType){
        Optional<PersonEntity> personOptional = personRepository.findById(id_person);
        if(personOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString()); }

        switch (outputType){
            case "full" -> {
                if(personRepository.isProfessor(id_person) == 1){
                    return ResponseEntity.ok().body(ProfessorEntityToDTO.iniProfessorFullDTO(professorRepository.findByIdPerson(id_person).get()));
                }
                if(personRepository.isStudent(id_person) == 1){
                    return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentFullDTO(studentRepository.findByIdPerson(id_person).get()));
                }
            }
            case "simple" -> {
                return ResponseEntity.ok().body(PersonEntityToDTO.iniPersonDTO(personOptional.get()));
            }
            default ->{
                return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
            }
        }

        return ResponseEntity.ok().body(PersonEntityToDTO.iniPersonDTO(personOptional.get()));
    }

    public void findByIdAndProfessor(int id_person){
        Map<String,String> sqlResult = personRepository.findByIdAndProfessor(id_person);
        if(sqlResult.isEmpty()){
            System.out.println("vacio");
        }

        personRepository.findByIdAndProfessor(id_person).entrySet().forEach(System.out::println);
    }

    public List<PersonEntity> findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    @Transactional(rollbackOn = SQLException.class)
    public PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception {
        personValidation(personInputDTO, "create");//validar campos de Person

        PersonEntity person = PersonDTOToEntity.iniPersonEntity(personInputDTO);//Entidad para poder guardar

        //para que se cumpla el rollback si hay un sqlException
        try{
            personRepository.save(person);

            return PersonEntityToDTO.iniPersonDTO(person);//DTO
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> modifyPerson(int id_persona, PersonInputDTO personModDTO) throws Exception {
        try{
            Optional<PersonEntity> persona = personRepository.findById(id_persona);

            if(persona.isEmpty()){
                return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
            }

            personValidation(personModDTO, "modify");//Validacion

            PersonEntity personMod = PersonDTOToEntity.iniPersonEntity(personModDTO);//Paso el DTO a Entidad
            personMod.setId_person(id_persona);
            personRepository.save(personMod);

            //DTO
            return ResponseEntity.ok().body(PersonEntityToDTO.iniPersonDTO(personMod));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> deletePerson(int id){
        Optional<PersonEntity> person = personRepository.findById(id);

        if(person.isPresent()){
            personRepository.delete(person.get());
            return ResponseEntity.ok().body("Row deleted successfully");
        }

        return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
    }

    public void personValidation(PersonInputDTO person, String type) throws Exception {
        //username field
        if(person.getUsername() == null){ throw new Exception("User field cannot be null"); }
        if(person.getUsername().length() < 6){ throw new Exception("The length of the username field cannot be less than 6 characters"); }
        if(person.getUsername().length() > 10){ throw new Exception("The length of the username field cannot be greater than 10 characters."); }

        //password field
        if(person.getPassword() == null){ throw new Exception("Password field cannot be null"); }

        //name field
        if(person.getName() == null){ throw new Exception("Name field cannot be null"); }

        //company_email field
        if(person.getCompany_email() == null){ throw new Exception("Company_email field cannot be null"); }

        //personal_email field
        if(person.getPersonal_email() == null){ throw new Exception("Personal_email field cannot be null"); }

        //city
        if(person.getCity() == null){ throw new Exception("City field cannot be null"); }

        switch(type){
            case "create":
                LocalDate fecha = LocalDate.now();

                //FECHA DE CREACION
                person.setCreated_date(fecha);
                //PONEMOS ACTIVO POR DEFECTO
                person.setActive(true);
                break;
            case "modify":
                if(person.getCreated_date() == null){ throw new Exception("Create_date field cannot be null"); }
                break;
        }
    }
}