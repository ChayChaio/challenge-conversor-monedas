package com.aluracursos.challengeconversormonedas.main;

import com.aluracursos.challengeconversormonedas.clases.ConsultaApi;
import com.aluracursos.challengeconversormonedas.clases.GeneradorDeJson;
import com.aluracursos.challengeconversormonedas.clases.ResultadoDelCambio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        ConsultaApi consulta = new ConsultaApi();
//
//        ResultadoDelCambio resultadoDelCambio = consulta.consultaCambio("cc918b80bb0e8c0a704ce2a4", "USD", "ARS", 20600);
//
//        System.out.println(resultadoDelCambio);

        ConsultaApi consulta = new ConsultaApi();
        ResultadoDelCambio resultado;
        List<ResultadoDelCambio> listaDeCAmbios = new ArrayList<>();
        Scanner lectura = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("   ¡Bienvenido al conversor de monedas!");
        System.out.println("*******************************************");
        System.out.println(" Para comenzar ingrese una APIKey válida:");
        String apiKey = lectura.next();
        int opcion = 0;
        double monto;


        while (opcion != 8){
            System.out.println("\n1.- Dólar =>> Peso Argentino");
            System.out.println("2.- Peso Argentino =>> Dólar");
            System.out.println("3.- Dólar =>> Real Brasileño");
            System.out.println("4.- Real Brasileño =>> Dólar");
            System.out.println("5.- Dólar =>> Peso Colombiano");
            System.out.println("6.- Peso Colombiano =>> Dólar");
            System.out.println("7.- Guardar...");
            System.out.println("8.- Salir");

            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el monto que desea cambiar:");
                    monto = lectura.nextDouble();
                    resultado = consulta.consultaCambio(apiKey, "USD", "ARS", monto);
                    resultado.mostrarAlmacenarResultado(resultado, listaDeCAmbios);
                    break;
                case 2:
                    System.out.println("Ingrese el monto que desea cambiar:");
                    monto = lectura.nextDouble();
                    resultado = consulta.consultaCambio(apiKey, "ARS", "USD", monto);
                    resultado.mostrarAlmacenarResultado(resultado, listaDeCAmbios);
                    break;
                case 3:
                    System.out.println("Ingrese el monto que desea cambiar:");
                    monto = lectura.nextDouble();
                    resultado = consulta.consultaCambio(apiKey, "USD", "BRL", monto);
                    resultado.mostrarAlmacenarResultado(resultado, listaDeCAmbios);
                    break;
                case 4:
                    System.out.println("Ingrese el monto que desea cambiar:");
                    monto = lectura.nextDouble();
                    resultado = consulta.consultaCambio(apiKey, "BRL", "USD", monto);
                    resultado.mostrarAlmacenarResultado(resultado, listaDeCAmbios);
                    break;
                case 5:
                    System.out.println("Ingrese el monto que desea cambiar:");
                    monto = lectura.nextDouble();
                    resultado = consulta.consultaCambio(apiKey, "USD", "COP", monto);
                    resultado.mostrarAlmacenarResultado(resultado, listaDeCAmbios);
                    break;
                case 6:
                    System.out.println("Ingrese el monto que desea cambiar:");
                    monto = lectura.nextDouble();
                    resultado = consulta.consultaCambio(apiKey, "COP", "USD", monto);
                    resultado.mostrarAlmacenarResultado(resultado, listaDeCAmbios);
                    break;
                case 7:
                    GeneradorDeJson generador = new GeneradorDeJson();
                    System.out.println("Por favor, ingrese el nombre con el que desea guardar el archivo:");
                    lectura.nextLine();
                    String archivo = lectura.nextLine();
                    generador.guardarJson(archivo, listaDeCAmbios);
                    System.out.println("Su archivo fue guardado correctamente!");
                    System.out.println("Gracias por usar nuestro conversor!");
                    opcion = 8;
                    break;

                default:
                    System.out.println("Gracias por usar nuestro conversor!");
            }
        }


    }



}
