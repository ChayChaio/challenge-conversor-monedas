package com.aluracursos.challengeconversormonedas.clases;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public ResultadoDelCambio consultaCambio(String apiKey, String monedaEntrada, String monedaSalida, double monto){

        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaEntrada + "/" + monedaSalida + "/" + monto;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ResultadoDelCambio.class);

        } catch (InterruptedException | IOException e) {

            throw new RuntimeException(e);
        }

    }
}
