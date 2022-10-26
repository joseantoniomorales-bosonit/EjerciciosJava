package com.bosonit.block6personcontrollers.services;

import org.springframework.stereotype.Service;

@Service
public class Ciudad {
    private String nombre;
    private int numeroHabitantes;

    public Ciudad(String nombre, int numeroHabitantes) {
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
    }

    public Ciudad(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", numeroHabitantes=" + numeroHabitantes +
                '}';
    }
}
