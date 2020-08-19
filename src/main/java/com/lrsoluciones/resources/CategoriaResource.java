package com.lrsoluciones.resources;

import com.lrsoluciones.resources.request.CategoriaRequest;
import com.lrsoluciones.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    private CategoriaService getCategoriaService() {
        return categoriaService;
    }

    //(POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<?> saveCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){// va a recibir el ItemRequest
                // ResponseEntity responseEntity = null;
            // solo lo graba si es distinto de null o no se encuentra vacio
        /*if ( !categoriaResquest.getCategoria().equals("") && categoriaResquest.getCategoria()!=null) {

            CategoriaResponse categoriaResponse = categoriasService.saveCategoria(categoriaResquest);
            responseEntity = new ResponseEntity(categoriaResponse, HttpStatus.OK);

        } else if (categoriaResquest.getCategoria().equals("") || categoriaResquest.getCategoria()==null) {
            responseEntity = new ResponseEntity( HttpStatus.BAD_REQUEST);
        }*/

        return getCategoriaService().saveCategoria(categoriaRequest);
    }

    //(IMPORTANTE) SOLO PUEDO USAR UN @GetMapping(value... SINO SE ROMPE!!! ASI QUE TRAIGO POR NOMBRE EN LUGAR DE ID!!
    // 127.0.0.1:8080/item/{id} este metodo pide datos de mi bbdd (GET)
   /* @GetMapping(value = "/{id}" ,produces = "application/json")
    public @ResponseBody ResponseEntity<?> getCategoriaById(@PathVariable("id") Long id){ // @ResponseBody significa que es el cuerpo de la respuesta
        ResponseEntity responseEntity = null;
        Optional<CategoriaResponse> categoriaResponse = Optional.ofNullable(categoriasService.getCategoriaById(id));

        // valida si categoria no esta vacio
        if (categoriaResponse.isPresent()) {
            // si los registros de la categoria son nulos tira error 404
            if (categoriaResponse.get().getCategoria()==null && categoriaResponse.get().getId()==null){
                responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
                // si los registros de la categoria estan completos tira estatus 200 y devuelve un json con las categorias
            } else if (categoriaResponse.get().getCategoria()!=null && categoriaResponse.get().getId()!=null) {
                responseEntity = new ResponseEntity(categoriaResponse,HttpStatus.OK);
            }
        }

        return responseEntity;
    }*/

    // (getAll) va sin value porque llamo a todos
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = "application/json") // me trae todas las categorias
    public @ResponseBody ResponseEntity<?> getAllCategorias(){ // @ResponseBody significa que es el cuerpo de la respuesta
        //List<CategoriaResponse> categoriaResponses = categoriasService.getAllCategorias();

        //return new ResponseEntity(categoriaResponses, HttpStatus.OK); // si no hay nada devueelve una lista vacia!!
        return getCategoriaService().getAllCategorias();
    }// no devolver en el front cualquier etiqueta basura, solo devolver el http standar 404 not found


    @GetMapping(value = "/{categoria}" ,produces = "application/json")
    public @ResponseBody ResponseEntity<?> getCategoriaByCategoria(@PathVariable("categoria") String categoria){ // @ResponseBody significa que es el cuerpo de la respuesta
      /*  ResponseEntity responseEntity = null;
        //List<CategoriaResponse> categoriaResponses = categoriasService.getCategoriaByCategoria(categoria);
        CategoriaResponse categoriaResponses = categoriasService.getCategoriaByCategoria(categoria);
        if (categoriaResponses!=null) {
                responseEntity = new ResponseEntity(categoriaResponses, HttpStatus.OK);
            } else if (categoriaResponses==null) {
                responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            }*/

            return getCategoriaService().getCategoriaByCategoria(categoria);
    }

    @DeleteMapping(value = "/{categoria}",produces = "application/json")
    public @ResponseBody ResponseEntity<?> deleteCategoria(@PathVariable("categoria") String categoria) {
        return getCategoriaService().deleteCategoria(categoria);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")// produce y consume un json
    public @ResponseBody ResponseEntity<?> updateCategoria(@RequestBody CategoriaRequest categoriaRequest) {
           /* CategoriaResponse categoriaResponse = categoriasService.updateCategoria(categoriaResquest);
           return new ResponseEntity(categoriaResponse,HttpStatus.OK);*/

        return getCategoriaService().updateCategoria(categoriaRequest);
    }
    }
