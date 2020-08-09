package com.lrsoluciones.services;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.models.Producto;
import com.lrsoluciones.repositories.PhotoRepository;
import com.lrsoluciones.repositories.ProductoRepository;
import com.lrsoluciones.resources.request.ProductoRequest;
import com.lrsoluciones.resources.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    PhotoRepository photoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    private ProductoRepository getProductoRepository() {
        return productoRepository;
    }

    //(POST)
    public ResponseEntity<?> saveProductos(ProductoRequest productoRequest){
        ResponseEntity<?> responseEntity;
        Producto producto;
       if (productoRequest.getCategoria()!=null &&
                !productoRequest.getCategoria().equals("") &&
                 productoRequest.getDescripcion()!=null &&
                  !productoRequest.getDescripcion().equals("")&&
                    productoRequest.getFoto()!= null &&
                    !productoRequest.getFoto().equals("") &&
                    productoRequest.getproducto()!=null &&
                    !productoRequest.getproducto().equals("")){
            producto = Producto.from(productoRequest);
            getProductoRepository().save(producto);

            responseEntity = new ResponseEntity<>(ProductoResponse.from(producto), HttpStatus.OK);


        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //(GET ALL)
    public ResponseEntity<?> getAllProductos(){ // aca llamo a todas las categorias

        Iterable<Producto> productoIterable =  getProductoRepository().findAll();
        List<ProductoResponse> productoResponseList = new ArrayList<>();
        ResponseEntity<?> responseEntity;
        for (Producto producto : productoIterable) {
            productoResponseList.add(ProductoResponse.from(producto));
        }
        if (!productoResponseList.isEmpty()){

            responseEntity = new ResponseEntity<>(productoResponseList, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  responseEntity;
    }

    //(LOGICA DE GET POR CATEGORIA)
    public ResponseEntity<?> getProductoByCategoria(Categoria categoria){// de esta forma buscamos la lista de producto por el id de la categoria
        ResponseEntity<?> responseEntity;
        List <Producto> productoList = getProductoRepository().findByCategoria(categoria);// me devuelve mi lista de productos por categorias
        List <ProductoResponse> productoResponseList = new ArrayList<>();
        if (!productoList.isEmpty()) {// si la lista no esta vacia la recorre crea y la guarda en una lista de productos response
            for (Producto producto:productoList) {
                productoResponseList.add(ProductoResponse.from(producto));
            }
            responseEntity = new ResponseEntity<>(productoResponseList,HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    // (LOGICA DE DELETE por producto)
    public ResponseEntity<?> deleteProducto(String producto) {
        ResponseEntity<?> responseEntity;
        Producto productoFind = getProductoRepository().findByProducto(producto);
        if (productoFind!=null) {
            getProductoRepository().delete(productoFind);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    // ESTE SE USA EN ProductosPorCategoriaResource
    // (LOGICA DE DELETE de todos los productos por categoria)
    public ResponseEntity<?> deleteAllProductosCategori(Categoria categoria) {
        ResponseEntity<?> responseEntity;
        List <Producto> productoList = getProductoRepository().findByCategoria(categoria);
        if (!productoList.isEmpty()) {
            for (Producto producto: productoList) {
                getProductoRepository().delete(producto);
            }
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }



    //(LOGICA UPDATE)
    public ResponseEntity<?> updateProducto (ProductoRequest productoRequest) {
        Optional<?> optional = getProductoRepository().findById(productoRequest.getId());
        ResponseEntity<?> responseEntity;
        Producto producto;
        if (optional.isPresent()){
            if (productoRequest.getCategoria()!=null &&
                    !productoRequest.getCategoria().equals("") &&
                    productoRequest.getDescripcion()!=null &&
                    !productoRequest.getDescripcion().equals("")&&
                    productoRequest.getFoto()!= null &&
                    !productoRequest.getFoto().equals("") &&
                    productoRequest.getproducto()!=null &&
                    !productoRequest.getproducto().equals("")){

                producto = Producto.from(productoRequest);
                getProductoRepository().save(producto);
                responseEntity = new ResponseEntity<>(ProductoResponse.from(producto), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}
