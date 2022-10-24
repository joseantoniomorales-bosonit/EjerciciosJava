package com.bosonit.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Clase3 {

    CommandLineRunner ejecutame3(String[] args) {
        return p -> {
             for (String i : args){
                 System.out.println(i);
             }
        };
    }
}
