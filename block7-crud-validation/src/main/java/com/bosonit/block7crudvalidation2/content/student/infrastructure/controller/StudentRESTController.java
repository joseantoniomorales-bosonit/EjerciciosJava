package com.bosonit.block7crudvalidation2.content.student.infrastructure.controller;

import com.bosonit.block7crudvalidation2.content.student.application.service.StudentService;
import com.bosonit.block7crudvalidation2.content.student.application.service.StudentServiceImp;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentInputDTO;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/estudiantes")
public class StudentRESTController {
    @Autowired
    StudentServiceImp studentService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name="id") int id, @RequestParam(defaultValue="simple") String outputType){
        return studentService.findById(id, outputType);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody StudentInputDTO studentInputDTO) throws Exception{
        try {
            return studentService.createStudent(studentInputDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> modify(@PathVariable(name="id") int id, @RequestBody StudentInputDTO studentInputDTO) throws Exception{
        try{
            return studentService.modifyStuedent(id, studentInputDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name="id") int id){
        try{
            return studentService.deleteStudent(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }
}
