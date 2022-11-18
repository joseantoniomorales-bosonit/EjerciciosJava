package com.bosonit.block7crudvalidation2.content.person.infrastructure;

import com.bosonit.block7crudvalidation2.content.person.application.service.PersonServiceImp;
import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonEntityToDTO;
import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input.PersonInputDTO;
import com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output.PersonOutputDTO;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonRESTController {
    @Autowired
    PersonServiceImp personServiceImp;

    //OBTENER TODAS LAS PERSONAS
    @GetMapping("")
    public List<PersonOutputDTO> getAll(){
        return personServiceImp.getAll();
    }

    //OBTENER PERSONA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id){
        Optional<PersonEntity> person = personServiceImp.findById(id);

        if(person.isPresent()){
            //DTO
            return ResponseEntity.ok().body(PersonEntityToDTO.iniPersonDTO(person.get()));
        }

        return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
    }

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
    public Object deletePerson(@PathVariable(value = "id") Integer id){
        return personServiceImp.deletePerson(id);
    }
}
