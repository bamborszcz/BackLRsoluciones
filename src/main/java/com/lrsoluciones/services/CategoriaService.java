package com.lrsoluciones.services;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.repositories.CategoriaRepository;
import com.lrsoluciones.resources.request.CategoriaRequest;
import com.lrsoluciones.resources.response.CategoriaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    private CategoriaRepository getCategoriaRepository() {// solo un getter en private porque nunca modifico mi repositorio y lo uso solo en esta clase
        return categoriaRepository;
    }

    // (LOGICA DEL POST)
    public ResponseEntity<?> saveCategoria(CategoriaRequest categoriaRequest){// va a recibir el ItemRequest
        ResponseEntity<?> responseEntity;
        Categoria categoria;
                  categoria = getCategoriaRepository().findByCategoria(categoriaRequest.getCategoria());
        if (categoria==null) { // busaca por categoria y si no existe la crea!!! asi no repite la misma categoria

            if (categoriaRequest.getCategoria()!=null && !categoriaRequest.getCategoria().equals("")){
                categoria = Categoria.from(categoriaRequest);
                getCategoriaRepository().save(categoria);
                responseEntity = new ResponseEntity<>(CategoriaResponse.from(categoria), HttpStatus.OK);

            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
           responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
        // devuelve un ItemResponse, porque siempre que guardo algo en la bbdd necesito obtener un objeto de respuesta
    }

    //(IMPORTANTE) SOLO PUEDO USAR UN @GetMapping(value... SINO SE ROMPE!!! ASI QUE TRAIGO POR NOMBRE EN LUGAR DE ID!!

   /* public CategoriaResponse getCategoriaById(Long id){

        Optional<Categorias> categorias =  categoriaRepository.findById(id);
        CategoriaResponse categoriaResponse = new CategoriaResponse();

        if (categorias.isPresent()) { // si categoria se encuentra en la bbdd va a crear categoriaResponse
            categoriaResponse = CategoriaResponse.from(categorias.get());// aca agrego el get porque es un observable!!!
            System.out.println(categorias.get().getCategoria());// si lo encuentra me devuelve el nombre de la categoria

        } else {
            System.out.println("item no encontrado!!");
        }

        return categoriaResponse;
    }*/

    // (LOGICA DEL GET "ALL")
    public ResponseEntity<?> getAllCategorias(){ // aca llamo a todas las categorias
       // Stream<Categorias> stream = StreamSupport.stream(categoriaRepository.findAll().spliterator(), false); // asi pide todos los items de la bbdd
        //return stream.map(categorias -> CategoriaResponse.from(categorias)).collect(Collectors.toList());// aca ya hasta recorrio la lista
        // ver los metodos (map, stream StramSuport, splititerator, collect, Collectors)(IMPORTANTE)!!!
        // ACA TRANSFORMA CADA UNO DE LOS ITEMS DEL EL STRAM EN UN ITEMrESPONSE Y LUEGO LOS TRANSFORMA EN UNA LISTA

        // "findall()" me devuelve un iterable de Categorias
        // lo recorro con un for, y lo guardo en una lista de CategoriaResponse
           Iterable<Categoria> categoriasIterable =  getCategoriaRepository().findAll();
           List <CategoriaResponse> categoriasList = new ArrayList<>();
            ResponseEntity<?> responseEntity;
             for (Categoria categoria : categoriasIterable) {
            categoriasList.add(CategoriaResponse.from(categoria));
             }
            if (!categoriasList.isEmpty()){

                responseEntity = new ResponseEntity<>(categoriasList, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        return  responseEntity;
    }

    //(LOGICA DE GET POR CATEGORIA)
    public ResponseEntity<?> getCategoriaByCategoria(String categoria){

       /*Stream<Categorias> stream = StreamSupport.stream(categoriaRepository.findByCategoria(categoria).
               spliterator(), false); // asi pide los productos   de la bbdd
        return stream.map(categorias -> CategoriaResponse.from(categorias)).collect(Collectors.toList()); */                           // por categoria
        //List <CategoriaResponse>categoriaResponseList= new ArrayList<>();
        //List <Categorias>categoriasList=categoriaRepository.findByCategoria(categoria);
        /*for (Categorias categorias : categoriasList) {
            categoriaResponseList.add(CategoriaResponse.from(categorias));
        }*/
        ResponseEntity<?> responseEntity;
        //CategoriaResponse categoriaResponse = null; // debo ponerlo en null para poder manejar los httpstatus en el getmaping
        // de lo contrario me tira un error nullpoiter!!!
        Categoria categorias = getCategoriaRepository().findByCategoria(categoria);
        if (categorias!=null) {
           responseEntity = new ResponseEntity<>(CategoriaResponse.from(categorias),HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }


    // (LOGICA DE DELETE)
    public ResponseEntity<?> deleteCategoria(String categoria) { // aca va un request porque el parametro va a modificar  mi bbdd
        // debo ponerlo en null para poder manejar los httpstatus en el getmaping
        // de lo contrario me tira un error nullpoiter!!!
        ResponseEntity<?> responseEntity;
        Categoria categorias = getCategoriaRepository().findByCategoria(categoria);
        if (categorias!=null) {
            getCategoriaRepository().delete(categorias);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }
    //(LOGICA UPDATE)
    public ResponseEntity<?> updateCategoria (CategoriaRequest categoriaRequest) {

        /*Categorias categorias =Categorias.from(categoriaResquest);

        categorias = categoriaRepository.save(categorias);

        return  CategoriaResponse.from(categorias);*/
        Optional<?> optional = getCategoriaRepository().findById(categoriaRequest.getId());
        ResponseEntity<?> responseEntity;
        Categoria categoria;
        if (optional.isPresent()){
            if (categoriaRequest.getCategoria()!=null && !categoriaRequest.getCategoria().equals("")){
                categoria = Categoria.from(categoriaRequest);
                getCategoriaRepository().save(categoria);
                responseEntity = new ResponseEntity<>(CategoriaResponse.from(categoria), HttpStatus.OK);

            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

}
