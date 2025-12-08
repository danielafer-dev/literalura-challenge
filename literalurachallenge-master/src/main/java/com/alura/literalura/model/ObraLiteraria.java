package com.alura.literalura.model;

import jakarta.persistence.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "obras")
public class ObraLiteraria {

    @Id
    private Long identificadorUnico;

    @Column(name = "nombre_obra", nullable = false)
    private String nombreObra;

    @Enumerated(EnumType.STRING)
    private Lenguaje idiomaPrincipal;

    private String tieneCopyright;
    private Integer conteoDescargas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escritor_fk", nullable = false)
    private Escritor escritor;

    public ObraLiteraria() {}

    public ObraLiteraria(DetallesObra detallesObra){
        this.identificadorUnico = detallesObra.identificador();
        this.nombreObra = detallesObra.titulo();
        this.idiomaPrincipal = Lenguaje.obtenerPorClave(detallesObra.listaIdiomas().stream()
                .limit(1).collect(Collectors.joining()));
        this.tieneCopyright = detallesObra.copyright();
        this.conteoDescargas = detallesObra.descargas();
    }

    public Long getIdentificadorUnico() {
        return identificadorUnico;
    }

    public void setIdentificadorUnico(Long identificadorUnico) {
        this.identificadorUnico = identificadorUnico;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public Lenguaje getIdiomaPrincipal() {
        return idiomaPrincipal;
    }

    public void setIdiomaPrincipal(Lenguaje idiomaPrincipal) {
        this.idiomaPrincipal = idiomaPrincipal;
    }

    public String getTieneCopyright() {
        return tieneCopyright;
    }

    public void setTieneCopyright(String tieneCopyright) {
        this.tieneCopyright = tieneCopyright;
    }

    public Integer getConteoDescargas() {
        return conteoDescargas;
    }

    public void setConteoDescargas(Integer conteoDescargas) {
        this.conteoDescargas = conteoDescargas;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    @Override
    public String toString() {
        return "ObraLiteraria{" +
                "Nombre='" + nombreObra + '\'' +
                ", Idioma=" + idiomaPrincipal +
                ", Descargas=" + conteoDescargas +
                '}';
    }
}