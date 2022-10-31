package com.bosonit.block7crud.controllers;

import com.bosonit.block7crud.entities.PersonEntity;
import com.bosonit.block7crud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/persona")
@RestController
public class AddPersonController {
    @Autowired
    PersonService personService;

   @PostMapping("")
    public String add(@RequestBody PersonEntity person){
        try{
            personService.create(person);
            return "ADD SUCCESS";
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR"+e.toString();
        }
    }
}
