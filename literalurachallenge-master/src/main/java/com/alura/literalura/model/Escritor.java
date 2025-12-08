package com.alura.literalura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "escritores")
public class Escritor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    @Column(name = "nombre_completo", unique = true, nullable = false)
    private String nombre;

    private Integer fechaNacimiento;
    private Integer fechaMuerte;

    @OneToMany(mappedBy = "escritor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ObraLiteraria> obras = new ArrayList<>();

    public Escritor() {}

    public Escritor(DatosEscritor datosEscritor) {
        this.nombre = datosEscritor.nombre();
        this.fechaNacimiento = datosEscritor.anioNacimiento();
        this.fechaMuerte = datosEscritor.anioMuerte();
    }

    public Long getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public List<ObraLiteraria> getObras() {
        return obras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public void setObras(List<ObraLiteraria> obras) {
        this.obras = obras;
        this.obras.forEach(o -> o.setEscritor(this));
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaMuerte=" + fechaMuerte +
                '}';
    }
}