package com.bosonit.block7crudvalidation2;

import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import com.bosonit.block7crudvalidation2.content.person.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartData {
    @Autowired
    PersonRepository personRepository;
    @Bean
    public void iniSQL(){
        PersonEntity person = new PersonEntity("josemo", "contrazeña", "jose",
                "morales", "joseantonio.morales@bosonit.com",
                "mi_email@personal.com", "Malaga");

        personRepository.save(person);
    }
}
