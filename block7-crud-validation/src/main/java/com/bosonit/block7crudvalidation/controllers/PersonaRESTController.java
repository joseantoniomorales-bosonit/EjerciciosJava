package com.bosonit.block7crudvalidation.controllers;

import com.bosonit.block7crudvalidation.entities.PersonaEntity;
import com.bosonit.block7crudvalidation.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public String findById(@PathVariable(value = "id") Integer id){
        Optional<PersonaEntity> persona = personaService.findById(id);

        if(persona.isPresent()){
            return persona.get().toString();
        }

        return "There is no row with that id";
    }

    @GetMapping("/nombre/{name}")
    public List<PersonaEntity> findByName(@PathVariable(value = "name") String name){
        return personaService.findByUsuario(name);
    }

    //CREAR UNA PERSONA
    @PostMapping("/create")
    public PersonaEntity addPersona(@RequestBody PersonaEntity persona) throws Exception {
        return personaService.addPersona(persona);
    }

    //EDITAR UNA PERSONA
    @PutMapping("/edit/{id}")
    public void modifyPersona(@PathVariable(value = "id") Integer id, @RequestBody PersonaEntity persona){
        personaService.modifyPersona();
    }

    //ELIMINAR UNA PERSONA
    @DeleteMapping("/del/{id}")
    public String deletePersona(@PathVariable(value = "id") Integer id){
        return personaService.deletePersona(id);
    }
}
