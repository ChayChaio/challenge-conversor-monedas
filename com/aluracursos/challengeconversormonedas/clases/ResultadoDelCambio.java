package com.aluracursos.challengeconversormonedas.clases;

public record ResultadoDelCambio(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {

    @Override
    public String toString() {
        return "Resultado: " + result + "!" +
                "\n Cambio de: " + base_code +
                " =>> " + target_code +
                "\n Tasa de conversión: " + conversion_rate +
                "\n Resultado de la conversión: "+ target_code + " " + conversion_result;
    }
}
