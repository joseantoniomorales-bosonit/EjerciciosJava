package com.bosonit.block7crudvalidation2;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.repository.CourseRepository;
import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.repository.PersonRepository;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class StartData {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Bean
    public void iniSQL(){
        List<CourseEntity> courseEntityList = new ArrayList<>();
        CourseEntity courseJava = new CourseEntity("Java","", LocalDate.now());
        CourseEntity coursePHP = new CourseEntity("PHP","", LocalDate.now());
        courseEntityList.add(courseJava);
        courseEntityList.add(coursePHP);

        PersonEntity person = new PersonEntity("josemo", "contrazeña", "jose",
                "morales", "joseantonio.morales@bosonit.com",
                "mi_email@personal.com", "Malaga");
        PersonEntity person2 = new PersonEntity("Lucia", "contrazeña", "Lucia",
                "Gil", "lucia.gil@bosonit.com",
                "mi_email@personal.com", "Malaga");

        personRepository.save(person);
        personRepository.save(person2);

        ProfessorEntity professor = new ProfessorEntity("","Java",person);
        professorRepository.save(professor);

        courseRepository.save(courseJava);
        courseRepository.save(coursePHP);
        courseRepository.save(new CourseEntity("React","", LocalDate.now()));

        StudentEntity student = new StudentEntity(30,"","Backend",person2,professor, courseEntityList);
        studentRepository.save(student);
    }
}
