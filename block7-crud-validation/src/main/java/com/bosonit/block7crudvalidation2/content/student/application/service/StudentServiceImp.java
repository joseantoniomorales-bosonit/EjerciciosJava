package com.bosonit.block7crudvalidation2.content.student.application.service;


import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseInputDTO;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.repository.CourseRepository;
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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CourseRepository courseRepository;

    public ResponseEntity<Object> findAll(){
        return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(studentRepository.findAll()));
    }

    public ResponseEntity<Object> findById(int id, String outputType){
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(student.isEmpty()) { return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString()); }

        switch (outputType) {
            case "full" -> {
                return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentFullDTO(student.get()));
            }
            case "simple" -> {
                return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(student.get()));
            }
            default -> {
                String msg = "EntityNotFoundException [Output type:"+outputType+" -> is not acceptable]";
                return ResponseEntity.status(404).body(new CustomError(new Date(), 404,msg).toString());
            }
        }
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> createStudent(StudentInputDTO studentInputDTO) throws Exception{
        validationStudent(studentInputDTO);//Validacion de student


        Optional<ProfessorEntity> professor = professorRepository.findById(studentInputDTO.getProfessor().getId_profesor());
        Optional<PersonEntity> person = personRepository.findById(studentInputDTO.getPerson().getId_person());

        //Si no encuentra a professor o a person devuelve un customError
        if(professor.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException -> Professor").toString()); }
        if(person.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException -> Person").toString()); }

        StudentEntity studentEntity = StudentDTOToEntity.iniStudentEntity(studentInputDTO);
        studentEntity.setProfessor(professor.get());//Seteo el objeto professor con el que tiene relacion
        studentEntity.setPerson(person.get());//Lo mismo pero con person

        if(studentRepository.countWithIdPerson(studentEntity.getPerson().getId_person()) != 0){
            throw new Exception("There is already a professor with that id_person");
        }

        try{
            studentRepository.save(studentEntity);

            return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(studentEntity));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public void addCourses(int id, List<CourseInputDTO> courseInputDTOs){
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if(studentEntity.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Person)").toString()); }

        List<CourseEntity> courseEntities = courseInputDTOs.stream().map(p -> courseRepository.findById(p.getId()).get()).toList();
        courseEntities.addAll(studentEntity.get().getCourse());

        Set<CourseEntity> coursesNoRepeat = new HashSet<>(courseEntities);//Para elminiar repetidos
        courseEntities.clear();
        courseEntities.addAll(coursesNoRepeat);

        studentEntity.get().setCourse(courseEntities);//Asignamos la lista de cursos

        studentRepository.save(studentEntity.get());
    }

    public void removeCourses(int id, List<CourseInputDTO> courseInputDTOs){
        //Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        //if(studentEntity.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Person)").toString()); }

        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("Student not found"));
        List<CourseEntity> courseEntities = student.getCourse();

        List<CourseEntity> courseToDelete = new ArrayList<>();
        //cursos que queremos eliminar del estudiante
        courseToDelete.stream().map(c -> courseRepository.findById(c.getId())).filter(Objects::nonNull).collect(Collectors.toList());

        student.setCourse(courseEntities.stream().filter(courseToDelete::contains).collect(Collectors.toList()));
        studentRepository.save(student);
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> modifyStuedent(int id, StudentInputDTO studentInputDTO) throws Exception{
        validationStudent(studentInputDTO);

        Optional<StudentEntity> studentOptional = studentRepository.findById(id);
        Optional<ProfessorEntity> professorOptional = professorRepository.findById(studentInputDTO.getProfessor().getId_profesor());
        Optional<PersonEntity> personOptional = personRepository.findById(studentInputDTO.getPerson().getId_person());

        if(studentOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException")); }
        if(professorOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Professor)")); }
        if(personOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Person)")); }

        StudentEntity studentEntity = StudentDTOToEntity.iniStudentEntity(studentInputDTO);
        studentEntity.setProfessor(professorOptional.get());
        studentEntity.setPerson(personOptional.get());

        try{
            studentRepository.save(studentEntity);

            return ResponseEntity.ok().body(StudentEntityToDTO.iniStudentDTO(studentEntity));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> deleteStudent(int id) throws Exception{
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if(studentEntityOptional.isEmpty()){ return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Professor ID)"));}

        try{
            studentRepository.delete(studentEntityOptional.get());
            return ResponseEntity.ok().body("Row deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public void validationStudent(StudentInputDTO studentInputDTO) throws Exception{
        if(studentInputDTO.getNum_hours_week() == null){ throw new Exception("Num hours week field cannot be null"); }
        if(studentInputDTO.getProfessor().getId_profesor() == null){ throw new Exception("Professor field cannot be null"); }
        if(studentInputDTO.getPerson().getId_person() == null){ throw new Exception("Person field cannot be null"); }
    }
}
