package com.bosonit.block7crudvalidation2.content.student.infrastructure.controller;

import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentInputDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class StudentRESTController {
    @GetMapping
    public void getAll(){

    }

    @GetMapping("/{id}")
    public void getById(@PathVariable(name="id") int id){

    }

    @PostMapping
    public void create(@RequestBody StudentInputDTO studentInputDTO){

    }

    @PutMapping("/{id}")
    public void modify(@PathVariable(name="id") int id, @RequestBody StudentInputDTO studentInputDTO){

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id") int id){

    }
}
