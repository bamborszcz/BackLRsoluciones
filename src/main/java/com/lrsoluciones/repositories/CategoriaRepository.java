package com.lrsoluciones.repositories;

import com.lrsoluciones.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {

    //@Query("select i from Categorias i where i.categoria = :nm")
    //Iterable<Categorias> findByCategoria(@Param("nm")String categoria);

    //este es el intuitivo, sin query
    //Iterable<Categorias> findByCategoria(String categoria);
     Categoria findByCategoria(String categoria);
}
