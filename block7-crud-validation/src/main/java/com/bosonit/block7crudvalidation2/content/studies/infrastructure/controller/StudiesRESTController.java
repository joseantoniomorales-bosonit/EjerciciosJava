package com.bosonit.block7crudvalidation2.content.studies.infrastructure.controller;

import com.bosonit.block7crudvalidation2.content.studies.infrastructure.dto.StudiesInputDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudios")
public class StudiesRESTController {
    @GetMapping
    public void getAll(){

    }

    @GetMapping("/{id}")
    public void getById(@PathVariable(name="id") int id){

    }

    @PostMapping
    public void create(@RequestBody StudiesInputDTO studiesInputDTO){

    }

    @PutMapping("/{id}")
    public void modify(@PathVariable(name="id") int id, @RequestBody StudiesInputDTO studiesInputDTO){

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id") int id){

    }
}
