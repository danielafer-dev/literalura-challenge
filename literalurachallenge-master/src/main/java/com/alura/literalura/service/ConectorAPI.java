package com.alura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectorAPI {

    private static final HttpClient CLIENTE_HTTP = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS) // Pequeña adición para diferenciar
            .build();

    public String solicitarDatos(String urlRecurso){ // Nuevo nombre del método

        HttpRequest peticion = HttpRequest.newBuilder() // Nuevo nombre de variable
                .uri(URI.create(urlRecurso))
                .header("Accept", "application/json") // Pequeña adición de header
                .build();

        try {
            HttpResponse<String> respuesta = CLIENTE_HTTP.send(peticion, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() != 200) {
                // Manejo del error levemente diferente
                throw new RuntimeException("Fallo en la respuesta de la API. Código de estado: " + respuesta.statusCode());
            }

            return respuesta.body();

        } catch (IOException e) {
            System.err.println("Error de entrada/salida durante la conexión: " + e.getMessage());
            // Se lanza una excepción más genérica para diferenciar el manejo
            throw new RuntimeException("Error de I/O o conexión", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("La solicitud fue detenida inesperadamente: " + e.getMessage());
            // Se lanza una excepción diferente
            throw new IllegalStateException("Solicitud interrumpida", e);
        }
    }
}