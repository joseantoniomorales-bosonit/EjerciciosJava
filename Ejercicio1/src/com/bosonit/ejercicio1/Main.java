package com.bosonit.ejercicio1;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public static List<Person> filtroMenores25(List<Person> lista){
        List<Person> menoresDe25 = lista.stream().filter(p -> p.getAge() < 25).map(person -> {
            if(person.getTown().equals("")){
                person.setTown("unknown");
            }
            return person;
        }).collect(Collectors.toList());

        return menoresDe25;
    }

    public static List<Person> nombresSinA(List<Person> lista){
        List<Person> nombresSinA = lista.stream().filter(p -> {
            char letra = p.getName().charAt(0);
                return letra != 'A';
            }).map(person -> {
                if(person.getTown().equals("")){
                    person.setTown("unknown");
                }
                return person;
            }).collect(Collectors.toList());

        return nombresSinA;
    }

    public static Optional<Person> buscarPorCiudad(List<Person> lista, String ciudad){
        List<Person> menoresDe25 = filtroMenores25(lista);

        return menoresDe25.stream().filter(p -> p.getTown().equals(ciudad)).findFirst();
    }

    public static void main(String[] args) {
        List<Person> listaPersonas = leer("/lista.csv");
        List<Person> menoresDe25 = filtroMenores25(listaPersonas);
        List<Person> nombreSinA = nombresSinA(listaPersonas);

        Optional<Person> ciudadMadrid = buscarPorCiudad(listaPersonas, "Madrid");
        Optional<Person> ciudadBarcelona = buscarPorCiudad(listaPersonas, "Barcelona");

        for(Person p : listaPersonas){
            System.out.println(" Name:"+p.getName()+" Town:"+p.getTown()+" Age:"+p.getAge());
        }

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("");

        menoresDe25.forEach(System.out::println);

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("");

        nombreSinA.forEach(System.out::println);

        if(ciudadMadrid.isPresent()){
            System.out.println();
            System.out.println("---------------------------------------------------------------");
            System.out.println("");

            System.out.println(ciudadMadrid); //Imprimo con el toString de Person
        }

        if(ciudadBarcelona.isPresent()){
            System.out.println();
            System.out.println("---------------------------------------------------------------");
            System.out.println("");

            System.out.println(ciudadBarcelona);
        }
    }
}