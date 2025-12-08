package com.alura.literalura.model;

public enum Lenguaje {
    ESPANOL("es", "Español"),
    RUSO("ru", "Ruso"),
    INGLES("en", "Inglés"),
    ITALIANO("it", "Italiano"),
    CHINO("zh", "Chino Mandarín");

    private final String claveIso;
    private final String denominacion;

    private Lenguaje(String claveIso, String denominacion) {
        this.claveIso = claveIso;
        this.denominacion = denominacion;
    }

    public String getClaveIso() {
        return claveIso;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public static Lenguaje obtenerPorClave(String text) {
        for (Lenguaje lenguaje : Lenguaje.values()) {
            if (lenguaje.getClaveIso().equalsIgnoreCase(text)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("No se encontró constante de Lenguaje con clave: " + text);
    }
}