package com.bosonit.block6personcontrollers.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public Persona bean1(){
        Persona p = new Persona("Bean1","Spring Boot",1);
        return p;
    }

    @Bean
    public Persona bean2(){
        Persona p = new Persona("Bean2","Spring Boot",2);
        return p;
    }

    @Bean
    public Persona bean3(){
        Persona p = new Persona("Bean3","Spring Boot",3);
        return p;
    }

    public Persona devolverBean(String opc){
        switch (opc){
            case "bean1":
                return bean1();
            case "bean2":
                return bean2();
            case "bean3":
                return bean3();
        }
        return new Persona("","",0);
    }
}
