package com.bosonit.block7crud.controllers;

import com.bosonit.block7crud.entities.PersonEntity;
import com.bosonit.block7crud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/persona")
@RestController
public class ModPersonController {
    @Autowired
    PersonService personService;

    @PutMapping("/{id}")
    public String modify(@PathVariable(value="id") int id, @RequestBody PersonEntity dataPerson){
        Optional<PersonEntity> person = personService.findById(id);

        if(person.isPresent()){
            dataPerson.setId(person.get().getId());
            personService.updatePerson(dataPerson);
            return "UPDATE SUCCESS";
        }

        return "UPDATE ERROR";
    }
}
