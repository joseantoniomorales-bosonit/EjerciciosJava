package com.bosonit.block7crudvalidation2.content.courses.infrastructure.controller;

import com.bosonit.block7crudvalidation2.content.courses.application.service.CourseServiceImp;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseInputDTO;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class CourseRESTController {
    @Autowired
    CourseServiceImp courseService;

    @GetMapping
    public List<CourseOutputDTO> getAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name="id") int id){
        return courseService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CourseInputDTO courseInputDTO) throws Exception{
        return courseService.createCourse(courseInputDTO);
    }

    @PutMapping("/{id}")
    public void modify(@PathVariable(name="id") int id, @RequestBody CourseInputDTO courseInputDTO){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name="id") int id) throws Exception{
        return courseService.deleteCourse(id);
    }
}
