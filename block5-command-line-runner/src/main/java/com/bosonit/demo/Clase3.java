package com.bosonit.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Clase3 {
    @Bean
    CommandLineRunner ejecutame3(String[] args) {
        for (String i : args){
            System.out.println(i);
        }
        return p -> {
            System.out.println(args.toString());
        };
    }
}
