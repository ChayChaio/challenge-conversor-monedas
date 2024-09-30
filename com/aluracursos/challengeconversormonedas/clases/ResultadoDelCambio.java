package com.aluracursos.challengeconversormonedas.clases;

import java.util.List;

public record ResultadoDelCambio(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {

    public void mostrarAlmacenarResultado(ResultadoDelCambio resultado, List lista){
        System.out.println("*******************************************");
        System.out.println(resultado);
        System.out.println("\n*******************************************");
        lista.add(resultado);

    }

    @Override
    public String toString() {
        return "\n Resultado: " + result + "!" +
                "\n Cambio de: " + base_code +
                " =>> " + target_code +
                "\n Tasa de conversión: " + conversion_rate +
                "\n Resultado de la conversión: "+ target_code + " " + conversion_result;
    }
}
