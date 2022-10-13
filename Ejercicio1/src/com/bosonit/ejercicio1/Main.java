package com.bosonit.ejercicio1;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static List<Person> leer(String ruta){
        List<Person> listaPersonas = new ArrayList<Person>();

        try{
            List<String> leerDocumento = Files.readAllLines(Path.of(ruta));

            for(String filaDoc : leerDocumento){
                String[] infoPersona = filaDoc.split(":");

                Pattern pat = Pattern.compile("[a-zA-Z]+\\:{1}[a-zA-Z]*\\:{1}[0-9]*");
                Matcher mat = pat.matcher(filaDoc);

                //Lanzo exc si no tiene nombre o no sigue el patron
                if(infoPersona[0].equals("") || !mat.find()){
                    throw new IOException("InvalidLineFormatException");
                }

                //si la longitud del array es 2 -> falta el ultimo campo (Edad)
                if(infoPersona.length == 2){
                    listaPersonas.add(new Person(infoPersona[0],infoPersona[1],0));
                }else{
                    listaPersonas.add(new Person(infoPersona[0],infoPersona[1],Integer.parseInt(infoPersona[2])));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return listaPersonas;
    }

    public static void leerConStream(){

    }

    public static void main(String[] args) {
        List<Person> listaPersonas = leer("C:/lista.csv");

        for(Person p : listaPersonas){
            System.out.println(" Name:"+p.getName()+" Town:"+p.getTown()+" Age:"+p.getAge());
        }
    }
}