package com.bosonit.block6simplecontrollers.controllers;

import com.bosonit.block6simplecontrollers.components.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@RequestMapping("/user")
public class Rutas {
    @Autowired
    Persona p;

    @GetMapping("/user/{nombre}")
    public String user(@PathVariable String nombre){
        p = new Persona(nombre,"",0);

        return "Hola "+p.getNombre();
    }

    @PostMapping("/useradd")
    public Persona useradd(@RequestBody String json){
        Map<String,String> persona =  p.convertirJSON(json);

        p = new Persona(persona.get("nombre"), persona.get("ciudad"),Integer.parseInt(persona.get("edad"))+1);
        return p;
    }
}
