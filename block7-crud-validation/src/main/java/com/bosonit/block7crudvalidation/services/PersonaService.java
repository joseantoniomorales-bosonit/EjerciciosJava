package com.bosonit.block7crudvalidation.services;

import com.bosonit.block7crudvalidation.entities.PersonaEntity;
import com.bosonit.block7crudvalidation.error.CustomError;
import com.bosonit.block7crudvalidation.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    public List<PersonaEntity> getAll(){
        return personaRepository.findAll();
    }

    public Optional<PersonaEntity> findById(int id_persona){
        return personaRepository.findById(id_persona);
    }

    public List<PersonaEntity> findByUsuario(String usuario){
        return personaRepository.findByUsuario(usuario);
    }

    public PersonaEntity addPersona(PersonaEntity persona) throws Exception {
        personaValidation(persona, "create");

        personaRepository.save(persona);
        return persona;
    }

    public Object modifyPersona(int id_persona, PersonaEntity personaMod) throws Exception {
        Optional<PersonaEntity> persona = findById(id_persona);
        if(persona.isEmpty()){
            return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
        }

        personaValidation(personaMod, "modify");
        personaMod.setId_persona(id_persona);

        personaRepository.save(personaMod);

        return personaMod;
    }

    public Object deletePersona(int id){
        Optional<PersonaEntity> persona = findById(id);

        if(persona.isPresent()){
            personaRepository.delete(persona.get());
            return "Row deleted successfully";
        }

        return ResponseEntity.status(404).body(new CustomError(new Date(), 404,"EntityNotFoundException").toString());
    }

    public void personaValidation(PersonaEntity persona, String type) throws Exception {
        //CAMPO USUARIO
        if(persona.getUsuario() == null){ throw new Exception("User field cannot be null"); }
        if(persona.getUsuario().length() < 6){ throw new Exception("The length of the username field cannot be less than 6 characters"); }
        if(persona.getUsuario().length() > 10){ throw new Exception("The length of the username field cannot be greater than 10 characters."); }

        //CAMPO PASSWORD
        if(persona.getPassword() == null){ throw new Exception("Password field cannot be null"); }

        //CAMPO NAME
        if(persona.getName() == null){ throw new Exception("Name field cannot be null"); }

        //CAMPO COMPANY_EMAIL
        if(persona.getCompany_email() == null){ throw new Exception("Company_email field cannot be null"); }

        //CAMPO PERSONAL_EMAIL
        if(persona.getPersonal_email() == null){ throw new Exception("Personal_email field cannot be null"); }

        //CAMPO CITY
        if(persona.getCity() == null){ throw new Exception("City field cannot be null"); }

        switch(type){
            case "create":
                LocalDate fecha = LocalDate.now();

                //FECHA DE CREACION
                persona.setCreated_date(fecha);
                //PONEMOS ACTIVO POR DEFECTO
                persona.setActive(true);
                break;
            case "modify":
                if(persona.getCreated_date() == null){ throw new Exception("Create_date field cannot be null"); }
                break;
        }

    }
}
