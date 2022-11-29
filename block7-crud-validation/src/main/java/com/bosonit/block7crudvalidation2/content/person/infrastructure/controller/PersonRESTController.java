package com.bosonit.block7crudvalidation2.content.person.infrastructure.controller;

import com.bosonit.block7crudvalidation2.content.person.application.service.PersonServiceImp;
import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import com.bosonit.block7crudvalidation2.feign.ProfessorFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonRESTController {
    @Autowired
    PersonServiceImp personServiceImp;

    @Autowired
    ProfessorFeign professorFeign;

    //OBTENER TODAS LAS PERSONAS
    @GetMapping("")
    public List<Object> getAll(@RequestParam(defaultValue = "simple") String outputType){
        return personServiceImp.getAll(outputType);
    }

    //OBTENER PERSONA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id, @RequestParam(defaultValue = "simple") String outputType){
        return personServiceImp.findById(id, outputType);
    }

    /*@GetMapping("p/{id}")
    public void findByIdAndProfessor(@PathVariable(value = "id") Integer id){
        personServiceImp.findByIdAndProfessor(id);
    }*/

    @GetMapping("/name/{username}")
    public List<PersonEntity> findByName(@PathVariable(value = "username") String username){
        return personServiceImp.findByUsername(username);
    }

    //CREAR UNA PERSONA
    @PostMapping("/create")
    public ResponseEntity<Object> addPerson(@RequestBody PersonInputDTO person) throws Exception {
        try{
            return ResponseEntity.ok().body(personServiceImp.addPerson(person));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    //EDITAR UNA PERSONA
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> modifyPerson(@PathVariable(value = "id") Integer id, @RequestBody PersonInputDTO person) throws Exception {
        try{
           return personServiceImp.modifyPerson(id, person);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    //ELIMINAR UNA PERSONA
    @DeleteMapping("/del/{id}")
    public Object deletePerson(@PathVariable(value = "id") Integer id) throws Exception{
        return personServiceImp.deletePerson(id);
    }

    @GetMapping("/profesor/{id}")
    public String getProfesor(@PathVariable int id) {
        String url = "http://localhost:8081/profesor/"+id;

        return new RestTemplate().getForObject(url, String.class);
    }

    @GetMapping("/feign/{id}")
    public String profesorFeign(@PathVariable int id) {
        return professorFeign.getProfesor(id);
    }
}
