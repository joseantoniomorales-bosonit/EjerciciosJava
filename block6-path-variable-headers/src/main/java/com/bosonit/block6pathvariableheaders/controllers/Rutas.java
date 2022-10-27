package com.bosonit.block6pathvariableheaders.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class Rutas {

    @PostMapping("")
    public String obtenerJSON(@RequestBody String json){
        return json;
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable(value="id") String id){
        return "El id del usuarios es: "+id;
    }

    @PutMapping("/post")
    public String peticionPUT(@RequestParam(required = false) String var1, @RequestParam(required = false) String var2){
        return "La var1 "+(var1 != null ? "es = "+var1 : "no se ha definido")+" y la var2 "+(var2 != null ? "es = "+var2 : "no se ha definido");
    }
}
