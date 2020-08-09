package com.lrsoluciones.resources;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.resources.request.ProductoRequest;
import com.lrsoluciones.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("productos")
public class ProductoResource {

    private final ProductoService productoService;

    @Autowired
    public ProductoResource(ProductoService productoService) {
        this.productoService = productoService;
    }

    private ProductoService getProductoService() {
        return productoService;
    }

    //(POST)
    @CrossOrigin(origins = "http://localhost:4200") // asi le doy permiso a mi servidor!!
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<?> saveProducto(@RequestBody @Valid ProductoRequest productoRequest){
        return getProductoService().saveProductos( productoRequest);
    }


    //(GET AllProductos)
    @CrossOrigin(origins = "http://localhost:4200") // asi le doy permiso a mi servidor!!
    @GetMapping(produces = "application/json") // me trae todas las categorias
    public @ResponseBody ResponseEntity<?> getAllProductos(){ // @ResponseBody significa que es el cuerpo de la respuesta
        return getProductoService().getAllProductos();
    }

    //(GET PRODUCTOS POR CATEGORIA)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{categoria}" ,produces = "application/json")
    public @ResponseBody ResponseEntity<?> getCategoriaByCategoria(@PathVariable("categoria") Categoria categoria){ // @ResponseBody significa que es el cuerpo de la respuesta
        return getProductoService().getProductoByCategoria(categoria);
    }

    @DeleteMapping(value = "/{producto}",produces = "application/json")
    public @ResponseBody ResponseEntity<?> deleteProducto(@PathVariable("producto") String producto) {
        return getProductoService().deleteProducto(producto);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")// produce y consume un json
    public @ResponseBody ResponseEntity<?> updateProducto(@RequestBody ProductoRequest productoRequest) {
        return getProductoService().updateProducto(productoRequest);
    }
}
