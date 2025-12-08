package com.alura.literalura.repository;

import com.alura.literalura.model.Escritor;
import com.alura.literalura.model.Lenguaje;
import com.alura.literalura.model.ObraLiteraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EscritorRepositorio extends JpaRepository<Escritor, Long> {

    @Query("SELECT e FROM Escritor e WHERE e.nombre = :nombre")
    Optional<Escritor> consultarEscritorPorNombre(@Param("nombre") String nombre);

    @Query("SELECT l FROM ObraLiteraria l WHERE l.nombreObra = :nombre")
    Optional<ObraLiteraria> consultarObraPorTitulo(@Param("nombre") String nombre);

    @Query("SELECT e FROM Escritor e WHERE e.fechaMuerte > :anio AND e.fechaNacimiento < :anio")
    List<Escritor> consultarEscritoresVivosEnAnio(@Param("anio") Integer anio);

    @Query("SELECT l FROM ObraLiteraria l WHERE l.idiomaPrincipal = :lenguaje")
    List<ObraLiteraria> consultarObrasPorLenguaje(@Param("lenguaje") Lenguaje lenguaje);

    @Query("SELECT l FROM ObraLiteraria l ORDER BY l.conteoDescargas DESC LIMIT 10")
    List<ObraLiteraria> consultarTop10Obras();

    @Query("SELECT e FROM Escritor e WHERE e.fechaNacimiento = :anio")
    List<Escritor> consultarEscritoresPorNacimiento(@Param("anio") Integer anio);

    @Query("SELECT e FROM Escritor e WHERE e.fechaMuerte = :anio")
    List<Escritor> consultarEscritoresPorMuerte(@Param("anio") Integer anio);

    @Query("SELECT l FROM ObraLiteraria l")
    List<ObraLiteraria> obtenerTodasLasObras();
}