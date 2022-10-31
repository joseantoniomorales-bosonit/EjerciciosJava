package com.bosonit.block7crud.services;

import com.bosonit.block7crud.entities.PersonEntity;
import com.bosonit.block7crud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public PersonEntity create(PersonEntity person){
        return personRepository.save(person);
    }

    public Optional<PersonEntity> findById(int personId){
        return personRepository.findById(personId);
    }

    public List<PersonEntity> findByName(String name){
        return personRepository.findByName(name);
    }

    public String deleteById(int personId){
        Optional<PersonEntity> person = findById(personId);
        if(person.isPresent()){
            personRepository.delete(person.get());
            return "DELETE OK";
        }

        return "ERROR DELETE";
    }

    public List<PersonEntity> findAll(){
        return personRepository.findAll();
    }

    public PersonEntity updatePerson(PersonEntity person){
        return personRepository.save(person);
    }
}
