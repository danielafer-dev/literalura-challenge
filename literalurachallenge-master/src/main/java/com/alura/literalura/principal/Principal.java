package com.alura.literalura.repository;

import com.alura.literalura.model.Escritor;
import com.alura.literalura.model.Lenguaje;
import com.alura.literalura.model.ObraLiteraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EscritorRepositorio extends JpaRepository<Escritor, Long> {

    @Query("SELECT l FROM ObraLiteraria l WHERE l.nombreObra ILIKE %:nombre%")
    Optional<ObraLiteraria> consultarObraPorTitulo(String nombre);

    @Query("SELECT e FROM Escritor e WHERE e.nombre ILIKE %:nombre%")
    Optional<Escritor> consultarEscritorPorNombre(String nombre);

    @Query("SELECT l FROM ObraLiteraria l")
    List<ObraLiteraria> obtenerTodasLasObras();

    @Query("SELECT e FROM Escritor e WHERE e.fechaNacimiento <= :anio AND (e.fechaMuerte IS NULL OR e.fechaMuerte > :anio)")
    List<Escritor> consultarEscritoresVivosEnAnio(Integer anio);

    @Query("SELECT l FROM ObraLiteraria l WHERE l.idiomaPrincipal = :lenguaje")
    List<ObraLiteraria> consultarObrasPorLenguaje(Lenguaje lenguaje);

    @Query("SELECT e FROM Escritor e WHERE e.fechaNacimiento = :anio")
    List<Escritor> consultarEscritoresPorNacimiento(Integer anio);

    @Query("SELECT e FROM Escritor e WHERE e.fechaMuerte = :anio")
    List<Escritor> consultarEscritoresPorMuerte(Integer anio);

    @Query("SELECT l FROM ObraLiteraria l ORDER BY l.conteoDescargas DESC LIMIT 10")
    List<ObraLiteraria> consultarTop10Obras();
}