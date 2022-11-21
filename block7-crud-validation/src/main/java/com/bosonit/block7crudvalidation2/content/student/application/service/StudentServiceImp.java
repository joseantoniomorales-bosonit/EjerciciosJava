package com.bosonit.block7crudvalidation2.content.student.application.service;


import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.repository.PersonRepository;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation2.content.student.application.mapper.StudentDTOToEntity;
import com.bosonit.block7crudvalidation2.content.student.application.mapper.StudentEntityToDTO;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.repository.StudentRepository;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentInputDTO;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    PersonRepository personRepository;

    public ResponseEntity<Object> findAll(){
        return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(studentRepository.findAll()));
    }

    public ResponseEntity<Object> findById(int id, String outputType){
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(student.isEmpty()) { ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException")); }

        switch (outputType) {
            case "full" -> {
                return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentFullDTO(student.get()));
            }
            case "simple" -> {
                return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(student.get()));
            }
            default -> {
                String msg = "EntityNotFoundException [Output type:"+outputType+" -> is not acceptable]";
                System.out.println(msg);
                return ResponseEntity.status(404).body(new CustomError(new Date(), 404,msg).toString());
            }
        }
    }

    public ResponseEntity<Object> createStudent(StudentInputDTO studentInputDTO) throws Exception{
        Optional<ProfessorEntity> professor = professorRepository.findById(studentInputDTO.getProfessor().getId_profesor());
        Optional<PersonEntity> person = personRepository.findById(studentInputDTO.getPerson().getId_person());

        //Si no encuentra a professor o a person devuelve un customError
        if(professor.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException -> Professor").toString()); }
        if(person.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException -> Person").toString()); }

        validationStudent(studentInputDTO);//Validacion de student
        StudentEntity studentEntity = StudentDTOToEntity.iniStudentEntity(studentInputDTO);
        studentEntity.setProfessor(professor.get());//Seteo el objeto professor con el que tiene relacion
        studentEntity.setPerson(person.get());//Lo mismo pero con person

        studentRepository.save(studentEntity);

        return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(studentEntity));
    }

    public void modifyStuedent(int id, StudentInputDTO studentInputDTO){

    }

    public ResponseEntity<Object> deleteStudent(int id){
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if(studentEntityOptional.isEmpty()){ return ResponseEntity.status(404).body("EntityNotFoundException");}

        studentRepository.delete(studentEntityOptional.get());

        return ResponseEntity.ok().body("Row deleted successfully");
    }

    public void validationStudent(StudentInputDTO studentInputDTO) throws Exception{
        if(studentInputDTO.getNum_hours_week() == null){ throw new Exception("Num hours week field cannot be null"); }
    }
}
