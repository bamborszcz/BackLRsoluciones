package com.lrsoluciones.resources;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productos-por-categoria")
public class ProductosPorCategoriaResource {

    private final ProductoService productoService;

    @Autowired
    public ProductosPorCategoriaResource(ProductoService productoService) {
        this.productoService = productoService;
    }

    private ProductoService getProductoService() {
        return productoService;
    }

    @DeleteMapping(value = "/{categoria}",produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> deleteProducto(@PathVariable("categoria") Categoria categoria) {
        return getProductoService().deleteAllProductosCategori(categoria);
    }

}
