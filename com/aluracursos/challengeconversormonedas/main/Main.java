package com.aluracursos.challengeconversormonedas.main;

import com.aluracursos.challengeconversormonedas.clases.ConsultaApi;
import com.aluracursos.challengeconversormonedas.clases.GeneradorDeJson;
import com.aluracursos.challengeconversormonedas.clases.ResultadoDelCambio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<ResultadoDelCambio> listaDeCambios = new ArrayList<>();
    public static int opcion = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaApi consulta = new ConsultaApi();
        String apiKey = obtenerApiKey();


        while (opcion != 8) {
            mostrarMenu();
            opcion = leerOpcion();

            if (opcion >= 1 && opcion <= 6) {
                manejarCambioMoneda(opcion, consulta, apiKey);
            } else if (opcion == 7) {
                guardarResultados();
            } else if (opcion == 8) {
                System.out.println("Gracias por usar nuestro conversor!");
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Método para obtener la API Key
    private static String obtenerApiKey() {
        System.out.println("*******************************************");
        System.out.println("   ¡Bienvenido al conversor de monedas!");
        System.out.println("*******************************************");
        System.out.print(" Para comenzar ingrese una APIKey válida: ");
        return scanner.next();
    }

    // Mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println(
                """
                \n1.- Dólar =>> Peso Argentino
                2.- Peso Argentino =>> Dólar
                3.- Dólar =>> Real Brasileño
                4.- Real Brasileño =>> Dólar
                5.- Dólar =>> Peso Colombiano
                6.- Peso Colombiano =>> Dólar
                7.- Guardar...
                8.- Salir
                """
        );
    }

    // Leer la opción seleccionada por el usuario
    private static int leerOpcion() {
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Por favor, ingrese una opción válida.");
            scanner.next();  // Limpiar el buffer
        }
        return opcion;
    }

    // Manejar las conversiones de moneda según la opción seleccionada
    private static void manejarCambioMoneda(int opcion, ConsultaApi consulta, String apiKey) throws IOException, InterruptedException {
        String base = "", target = "";
        switch (opcion) {
            case 1 -> { base = "USD"; target = "ARS"; }
            case 2 -> { base = "ARS"; target = "USD"; }
            case 3 -> { base = "USD"; target = "BRL"; }
            case 4 -> { base = "BRL"; target = "USD"; }
            case 5 -> { base = "USD"; target = "COP"; }
            case 6 -> { base = "COP"; target = "USD"; }
        }

        double monto = leerMonto();
        ResultadoDelCambio resultado = consulta.consultaCambio(apiKey, base, target, monto);
        resultado.mostrarResultado();
        resultado.almacenarResultado(listaDeCambios);
    }

    // Leer el monto ingresado por el usuario
    private static double leerMonto() {
        double monto = -1;
        while (monto <= 0) {
            System.out.print("Ingrese el monto que desea cambiar: ");
            try {
                monto = scanner.nextDouble();
                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a 0.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.next();  // Limpiar el buffer
            }
        }
        return monto;
    }

    // Guardar los resultados de las conversiones en un archivo JSON
    private static void guardarResultados() {
        if (listaDeCambios.isEmpty()) {
            System.out.println("Realice primero una conversión para guardar en el archivo.");
        } else {
            System.out.print("Por favor, ingrese el nombre con el que desea guardar el archivo: ");
            scanner.nextLine();  // Limpiar el buffer
            String archivo = scanner.nextLine();
            GeneradorDeJson generador = new GeneradorDeJson();
            generador.guardarJson(archivo, listaDeCambios);
            System.out.println("Su archivo fue guardado correctamente!");
            System.out.println("Gracias por usar nuestro conversor!");
            opcion = 8;
        }
    }
}
