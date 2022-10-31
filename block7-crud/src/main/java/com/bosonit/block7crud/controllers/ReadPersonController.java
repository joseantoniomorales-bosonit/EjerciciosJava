package com.bosonit.block7crud.controllers;

import com.bosonit.block7crud.entities.PersonEntity;
import com.bosonit.block7crud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/persona")
@RestController
public class ReadPersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public String readWithId(@PathVariable(value="id") int id){
        Optional<PersonEntity> person = personService.findById(id);

        if(person.isPresent()){
            return person.get().toString();
        }

        return "No exists this user";
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonEntity> readWithName(@PathVariable(value="nombre") String name){
        return personService.findByName(name);
    }
}
