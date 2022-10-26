package com.bosonit.block6simplecontrollers.components;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@Component
public class Persona {
    private String nombre;
    private String poblacion;
    private int edad;

    public Persona(String nombre, String pobacion, int edad){
        this.nombre = nombre;
        this.poblacion = pobacion;
        this.edad = edad;
    }

    public Persona(){

    }

    public String getNombre(){
        return this.nombre;
    }

    public String getPoblacion(){
        return this.poblacion;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", edad=" + edad +
                '}';
    }

    public Map<String,String> convertirJSON(String json){
        Map<String, String> map;
        try{
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(json, Map.class);
            return map;
        }catch(Exception e){
            e.printStackTrace();
        }
        map = new HashMap<>();
        map.put("nomre","");
        map.put("ciudad","");
        map.put("edad","0");
        return map;
    }

}
