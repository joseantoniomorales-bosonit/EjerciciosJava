package com.bosonit.block7crudvalidation2.content.student.application.service;

import com.bosonit.block7crudvalidation2.content.student.domain.repository.StudentRepository;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void findAll(){
        studentRepository.findAll();
    }

    public void findById(int id){

    }

    public void createStudent(StudentInputDTO studentInputDTO){

    }

    public void modifyStuedent(int id, StudentInputDTO studentInputDTO){

    }

    public void deleteStudent(int id){

    }

    public void validationStudent(StudentInputDTO studentInputDTO) throws Exception{

    }
}
