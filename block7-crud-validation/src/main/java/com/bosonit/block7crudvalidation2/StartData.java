package com.bosonit.block7crudvalidation2;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.repository.PersonRepository;
import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartData {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    StudentRepository studentRepository;

    @Bean
    public void iniSQL(){
        PersonEntity person = new PersonEntity("josemo", "contrazeña", "jose",
                "morales", "joseantonio.morales@bosonit.com",
                "mi_email@personal.com", "Malaga");

        personRepository.save(person);

        ProfessorEntity professor = new ProfessorEntity("","Java",person);
        professorRepository.save(professor);

        StudentEntity student = new StudentEntity(30,"","Backend",person,professor);
        studentRepository.save(student);
    }
}
