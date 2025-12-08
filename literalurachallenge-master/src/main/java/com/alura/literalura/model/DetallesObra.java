package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DetallesObra(
        @JsonAlias("id") Long identificador,
        @JsonAlias("title") String nombrePrincipal,
        @JsonAlias("authors") List<DatosEscritor> listaEscritores, // Referencia al nuevo DTO
        @JsonAlias("languages") List<String> listaIdiomas,
        @JsonAlias("copyright") String tieneDerechos,
        @JsonAlias("download_count") Integer conteoDescargas) {
}