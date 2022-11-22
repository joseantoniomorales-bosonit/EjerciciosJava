package com.bosonit.block7crudvalidation2.content.student.application.service;

import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentInputDTO;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<Object> findAll();
    ResponseEntity<Object> findById(int id, String outputType);
    ResponseEntity<Object> createStudent(StudentInputDTO studentInputDTO) throws Exception;
    ResponseEntity<Object> modifyStuedent(int id, StudentInputDTO studentInputDTO) throws Exception;
    ResponseEntity<Object> deleteStudent(int id) throws Exception;
}
