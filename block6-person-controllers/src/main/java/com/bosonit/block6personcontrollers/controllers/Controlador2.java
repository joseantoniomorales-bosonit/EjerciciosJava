package com.bosonit.block6personcontrollers.controllers;

import com.bosonit.block6personcontrollers.services.Ciudad;
import com.bosonit.block6personcontrollers.services.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {

    Persona p;
    @Autowired
    Controlador1 c1;

    @GetMapping("/controlador2/getPersona")
    public Persona getPersona(){
        p = c1.getP();
        p.setEdad(p.getEdad()*2);
        return p;
    }

    @GetMapping("/controlador2/getCiudad")
    public List<Ciudad> getCiudad(){
        return c1.getCiudades();
    }


}
