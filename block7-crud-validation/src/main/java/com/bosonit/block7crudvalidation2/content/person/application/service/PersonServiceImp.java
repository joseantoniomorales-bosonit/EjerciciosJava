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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService{
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    StudentRepository studentRepository;
    public List<Object> getAll(String outputType){
       return personRepository.findAll().stream().map(p ->{
            Optional optional = findOutputType(p.getId_person(), outputType);

            if(optional.isPresent()){
                if(optional.get() instanceof ProfessorEntity){
                    return ProfessorEntityToDTO.iniProfessorFullDTO((ProfessorEntity) optional.get());
                }

                if(optional.get() instanceof StudentEntity){
                    return StudentEntityToDTO.iniStudentFullDTO((StudentEntity) optional.get());
                }
            }

            return PersonEntityToDTO.iniPersonDTO(p);
        }).collect(Collectors.toList());
    }

    public ResponseEntity<Object> findById(int id_person, String outputType){
        Optional<PersonEntity> personOptional = personRepository.findById(id_person);
        if(personOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString()); }

        Optional optional = findOutputType(id_person,outputType);

        if(optional.isPresent()){
            if(optional.get() instanceof ProfessorEntity){
                return ResponseEntity.ok().body(ProfessorEntityToDTO.iniProfessorFullDTO((ProfessorEntity) optional.get()));
            }

            if(optional.get() instanceof StudentEntity){
                return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentFullDTO((StudentEntity) optional.get()));
            }
        }

        return ResponseEntity.ok().body(PersonEntityToDTO.iniPersonDTO(personOptional.get()));
    }

    public List<PersonEntity> findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    private Optional findOutputType(int id_person,String outputType){
        Optional<PersonEntity> personOptional = personRepository.findById(id_person);
        switch (outputType){
            case "full" -> {
                if(personRepository.isProfessor(id_person) == 1){
                    return professorRepository.findByIdPerson(id_person);
                }
                if(personRepository.isStudent(id_person) == 1){
                    return studentRepository.findByIdPerson(id_person);
                }
            }
            case "simple" -> {
                return personOptional;
            }
        }

        return Optional.empty();
    }

    /* public void findByIdAndProfessor(int id_person){
        Map<String,String> sqlResult = personRepository.findByIdAndProfessor(id_person);
        if(sqlResult.isEmpty()){
            System.out.println("vacio");
        }

        personRepository.findByIdAndProfessor(id_person).entrySet().forEach(System.out::println);
    }*/

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
    public ResponseEntity<Object> deletePerson(int id) throws Exception{
        Optional<PersonEntity> person = personRepository.findById(id);

        if(person.isPresent()){
            if(personRepository.isDelete(person.get().getId_person()) == 0){
                try{
                    personRepository.delete(person.get());
                    return ResponseEntity.ok().body("Row deleted successfully");
                }catch (Exception e){
                    e.printStackTrace();
                    throw new SQLException();
                }
            }
            return ResponseEntity.ok().body("This person is a professor or a student, cannot be deleted");
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