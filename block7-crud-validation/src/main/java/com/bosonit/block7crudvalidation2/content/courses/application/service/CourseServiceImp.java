package com.bosonit.block7crudvalidation2.content.courses.application.service;

import com.bosonit.block7crudvalidation2.content.courses.application.mapper.CourseDTOToEntity;
import com.bosonit.block7crudvalidation2.content.courses.application.mapper.CourseEntityToDTO;
import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseInputDTO;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseOutputDTO;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.repository.CourseRepository;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.repository.StudentRepository;
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
public class CourseServiceImp implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;

    public List<CourseOutputDTO> findAll(){
        return CourseEntityToDTO.iniCourseDTO(courseRepository.findAll());
    }

    public ResponseEntity<Object> findById(int id){
        Optional<CourseEntity> courseOptional = courseRepository.findById(id);
        if(courseOptional.isEmpty()){
            return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
        }

        return ResponseEntity.ok().body(CourseEntityToDTO.iniCourseDTO(courseOptional.get()));//Devuelvo el DTO
    }

    @Transactional(rollbackOn = SQLException.class)
    public void createCourse(CourseInputDTO courseInputDTO) throws Exception{
        validationCouse(courseInputDTO); //Validacion de los campos

        Optional<StudentEntity> studentOptional = studentRepository.findById(courseInputDTO.getStudent().getId());
        Optional<ProfessorEntity> professorOptional = professorRepository.findById(courseInputDTO.getProfessor().getId_profesor());

        if(studentOptional.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Student)").toString()); }
        if(professorOptional.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Professor)").toString()); }

        CourseEntity courseEntity = CourseDTOToEntity.iniCourseEntity(courseInputDTO);
       // courseEntity.setStudent(studentOptional.get());
        //courseEntity.setProfessor(professorOptional.get());

        try{
            courseRepository.save(courseEntity);

            ResponseEntity.ok().body(CourseEntityToDTO.iniCourseDTO(courseEntity));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public void modifyCourse(int id, CourseInputDTO courseInputDTO) throws Exception{
        validationCouse(courseInputDTO);

        Optional<CourseEntity> courseOptional = courseRepository.findById(id);
        Optional<StudentEntity> studentOptional = studentRepository.findById(courseInputDTO.getStudent().getId());
        Optional<ProfessorEntity> professorOptional = professorRepository.findById(courseInputDTO.getProfessor().getId_profesor());

        if(courseOptional.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Student)").toString()); }
        if(studentOptional.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Student)").toString()); }
        if(professorOptional.isEmpty()){ ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException (Professor)").toString()); }
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> deleteCourse(int id) throws Exception{
        Optional<CourseEntity> courseOptional = courseRepository.findById(id);

        if(courseOptional.isEmpty()){
            return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
        }

        try{
            courseRepository.delete(courseOptional.get());

            return ResponseEntity.ok().body(CourseEntityToDTO.iniCourseDTO(courseOptional.get()));
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public void validationCouse(CourseInputDTO courseInputDTO) throws Exception{
        if(courseInputDTO.getName() == null){ throw new Exception(""); }
    }
}
