package com.lrsoluciones.repositories;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.models.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    List <Producto> findByCategoria(Categoria categoria); // asi buscamos los productos por "id" de la categoria
    Producto findByProducto(String producto);
}
