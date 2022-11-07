package com.bosonit.block7crudvalidation.controllers;

import com.bosonit.block7crudvalidation.entities.PersonaEntity;
import com.bosonit.block7crudvalidation.error.CustomError;
import com.bosonit.block7crudvalidation.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaRESTController {
    @Autowired
    PersonaService personaService;

    //OBTENER TODAS LAS PERSONAS
    @GetMapping("")
    public List<PersonaEntity> getAll(){
        return personaService.getAll();
    }

    //OBTENER PERSONA POR ID
    @GetMapping("/{id}")
    public Object findById(@PathVariable(value = "id") Integer id){
        Optional<PersonaEntity> persona = personaService.findById(id);

        if(persona.isPresent()){
            return persona.get();
        }

        return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
    }

    @GetMapping("/nombre/{name}")
    public List<PersonaEntity> findByName(@PathVariable(value = "name") String name){
        return personaService.findByUsuario(name);
    }

    //CREAR UNA PERSONA
    @PostMapping("/create")
    public Object addPersona(@RequestBody PersonaEntity persona) throws Exception {
        try{
            return personaService.addPersona(persona);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    //EDITAR UNA PERSONA
    @PutMapping("/edit/{id}")
    public Object modifyPersona(@PathVariable(value = "id") Integer id, @RequestBody PersonaEntity persona) throws Exception {
        try{
           return personaService.modifyPersona(id, persona);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    //ELIMINAR UNA PERSONA
    @DeleteMapping("/del/{id}")
    public String deletePersona(@PathVariable(value = "id") Integer id){
        return personaService.deletePersona(id);
    }
}
