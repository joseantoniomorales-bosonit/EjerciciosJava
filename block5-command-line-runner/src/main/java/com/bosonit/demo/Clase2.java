package com.bosonit.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class Clase2 {

    @Bean
    CommandLineRunner ejecutame2()
    {
        return p -> {
            System.out.println("Hola desde clase secundaria");
        };
    }
}
