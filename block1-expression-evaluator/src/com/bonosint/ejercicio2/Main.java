package com.bonosint.ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String tipoDeOperacion(String fila){
        String[] partes = fila.split(" ");

        if(partes.length > 0){

            //PATRON DE CADENA
            Pattern patStr = Pattern.compile("[a-zA-Z]+");
            Matcher matStr = patStr.matcher(partes[0]);
            if(matStr.find()){
               return fila+":  \t"+tratarCadena(partes);
            }

            //PATRON DE FECHA
            Pattern patFec = Pattern.compile("[0-9]{4}/[0-9]{2}/[0-9]{2}");
            Matcher matFec = patFec.matcher(partes[0]);
            if(matFec.find()){
                return fila+":  \t"+tratarFecha(partes);
            }else{
                //PATRON NUMERICO (lo pongo en el else porque la fecha empieza con numeros)
                Pattern patNum = Pattern.compile("[0-9]+");
                Matcher matNum = patNum.matcher(partes[0]);
                if(matNum.find()){
                    return fila+":  \t"+calcularNum(partes);
                }
            }
        }
        return "Error: No se ha reconocido el tipo de operación";
    }

    private static String calcularNum(String[] partes){
        int total = Integer.parseInt(partes[0]);
        for(int i = 0; i < partes.length; i++){
            if(i % 2 != 0 && i+1 < partes.length){
                switch (partes[i]){
                    case "+":
                        total += Integer.parseInt(partes[i+1]);
                        break;
                    case "-":
                        total -= Integer.parseInt(partes[i+1]);
                        break;
                    case "/":
                        total /= Integer.parseInt(partes[i+1]);
                        break;
                    case "*":
                        total *= Integer.parseInt(partes[i+1]);
                        break;
                }
            }
        }

        return "Resultado = "+total;
    }

    private static String tratarCadena(String[] partes){
        String resultado = partes[0].substring(1,partes[0].length()-1);
        for(int i = 0; i < partes.length; i++) {
            if (i % 2 != 0 && i + 1 < partes.length) {
                switch (partes[i]) {
                    case "+":
                        resultado += partes[i + 1].substring(1, partes[i + 1].length() - 1);
                        break;
                    case "*":
                        resultado += partes[i + 1].substring(1, partes[i + 1].length() - 1) + partes[i + 1].substring(1, partes[i + 1].length() - 1);
                        break;
                }
            }
        }

       return "Resultado= "+resultado;
    }

    private static String tratarFecha(String[] partes){
        return "Tratando fecha";
    }

    public static List<String> leerFichero(){
        List<String> filas = new ArrayList<>();

        try{
            File arc = new File("src/fichero.txt");
            FileReader fr = new FileReader (arc);
            BufferedReader br = new BufferedReader(fr);

            String fila;

            while((fila=br.readLine()) != null){
                filas.add(fila);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return filas;
    }

    public static void main(String[] args) {
        List<String> filas = leerFichero();

        for(String fila : filas){
            System.out.println(tipoDeOperacion(fila));
        }
    }
}