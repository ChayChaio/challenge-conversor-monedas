package com.aluracursos.challengeconversormonedas.clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeJson {

    public void guardarJson(String nombreDeArchivo, List lista){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            FileWriter escritura = new FileWriter(nombreDeArchivo + ".txt");
            escritura.write(gson.toJson(lista));
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
