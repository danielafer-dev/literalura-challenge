package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransformadorDatos implements IDataProcessor {

    private final ObjectMapper mapperJson = new ObjectMapper();

    @Override
    public <T> T procesarJson(String contenidoJson, Class<T> tipoDestino) {
        try {
            return mapperJson.readValue(contenidoJson, tipoDestino);
        } catch (JsonProcessingException e) {
            System.err.println("Fallo durante el mapeo del contenido JSON.");
            throw new IllegalStateException("Fallo en la conversión de JSON", e);
        }
    }
}