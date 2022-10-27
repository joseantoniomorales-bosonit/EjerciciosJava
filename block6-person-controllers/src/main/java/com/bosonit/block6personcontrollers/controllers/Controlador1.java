package com.bosonit.block6personcontrollers.controllers;

import com.bosonit.block6personcontrollers.services.Beans;
import com.bosonit.block6personcontrollers.services.Ciudad;
import com.bosonit.block6personcontrollers.services.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {
    @Autowired
    @Qualifier("bean1")
    Persona p;

    List<Ciudad> ciudades = new ArrayList<>();

    @GetMapping("/controlador1/addPersona")
    public Persona addPersona(@RequestHeader String nombre, @RequestHeader String poblacion, @RequestHeader int edad){
        p = new Persona(nombre, poblacion,edad);
        return p;
    }

    public Persona getP() {
        return p;
    }

    @Bean
    public void generarCiudades(){
        ciudades.add(new Ciudad("Malaga",300));
        ciudades.add(new Ciudad("Sevilla",290));
        ciudades.add(new Ciudad("Granada",200));
        ciudades.add(new Ciudad("Huelva",120));
    }

    @PostMapping("/controlador1/addCiudad")
    public void addCiudad(@RequestParam String nombre, @RequestParam int numeroHabitantes){
        ciudades.add(new Ciudad(nombre, numeroHabitantes));
    }

    public List<Ciudad> getCiudades(){
        return ciudades;
    }


    @GetMapping("/controlador/bean/{bean}")
    public Persona mostrarBean(@PathVariable String bean){
        Beans b = new Beans();
        return b.devolverBean(bean);
    }
}
