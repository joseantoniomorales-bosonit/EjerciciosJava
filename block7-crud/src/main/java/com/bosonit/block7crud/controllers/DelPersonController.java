package com.bosonit.block7crud.controllers;

import com.bosonit.block7crud.repositories.PersonRepository;
import com.bosonit.block7crud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/persona")
@RestController
public class DelPersonController {
    @Autowired
    PersonService personService;

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value="id") int id){
       return personService.deleteById(id);
    }
}
