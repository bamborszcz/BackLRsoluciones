package com.lrsoluciones.resources;

import com.lrsoluciones.models.FooterImg;
import com.lrsoluciones.models.Producto;
import com.lrsoluciones.resources.request.FooterRequest;
import com.lrsoluciones.resources.request.ProductoRequest;
import com.lrsoluciones.resources.response.FooterResponse;
import com.lrsoluciones.resources.response.ProductoResponse;
import com.lrsoluciones.services.FooterService;
import com.lrsoluciones.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("footerImg")
public class FooterResource {
    private final FooterService footerService;

    @Autowired
    public FooterResource(FooterService footerService) {
        this.footerService = footerService;
    }

    private FooterService getFooterService() {
        return footerService;
    }

    //(POST)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<?> saveFooter(@RequestBody @Valid FooterRequest footerRequest){
        return getFooterService().saveFooterImg(footerRequest);
    }

    //(GET Footer POR Foto)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{foto}" ,produces = "application/json")
    public @ResponseBody ResponseEntity<?> getFooterByFoto(@PathVariable("foto") String foto){ // @ResponseBody significa que es el cuerpo de la respuesta
        return getFooterService().getFooterByFoto(foto);
    }

    //(FOTO)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getFooterByFoto(){ // @ResponseBody significa que es el cuerpo de la respuesta
        Iterable<FooterImg> footerImgIterable =  getFooterService().getFooterRepository().findAll();
        List<FooterResponse> footerResponseList = new ArrayList<>();
        ResponseEntity<?> responseEntity;
        for (FooterImg footerImg : footerImgIterable) {
            footerResponseList.add(FooterResponse.from(footerImg));
        }
        if (!footerResponseList.isEmpty()){

            responseEntity = new ResponseEntity<>(footerResponseList, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  responseEntity;
    }

    @DeleteMapping(value = "/{foto}",produces = "application/json")
    public @ResponseBody ResponseEntity<?> deleteFooter(@PathVariable("foto") String foto) {
        return getFooterService().deleteFooterByFoto(foto);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")// produce y consume un json
    public @ResponseBody ResponseEntity<?> updateFooter(@RequestBody FooterRequest footerRequest) {
        return getFooterService().updateFooter(footerRequest);
    }
}
