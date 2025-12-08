package com.alura.literalura.service;

public interface IDataProcessor {
    <T> T procesarJson(String contenidoJson, Class<T> tipoDestino);
}