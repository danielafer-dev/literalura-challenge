package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoBusqueda(
        @JsonAlias("count") Integer conteoTotal,
        @JsonAlias("results") List<DetallesObra> listaObras) {
}