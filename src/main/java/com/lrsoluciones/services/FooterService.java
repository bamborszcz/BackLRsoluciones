package com.lrsoluciones.services;

import com.lrsoluciones.models.FooterImg;
import com.lrsoluciones.models.Producto;
import com.lrsoluciones.repositories.FooterRepository;
import com.lrsoluciones.resources.request.FooterRequest;
import com.lrsoluciones.resources.request.ProductoRequest;
import com.lrsoluciones.resources.response.FooterResponse;
import com.lrsoluciones.resources.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FooterService {

    private final FooterRepository footerRepository;

    @Autowired
    public FooterService(FooterRepository footerRepository) {
        this.footerRepository = footerRepository;
    }

    public FooterRepository getFooterRepository() {
        return footerRepository;
    }

    //(POST)
    public ResponseEntity<?> saveFooterImg(FooterRequest footerRequest){
        ResponseEntity<?> responseEntity;
        FooterImg footerImg;
        if (footerRequest.getFoto()!=null &&
                !footerRequest.getFoto().equals("") ){
            footerImg = FooterImg.from(footerRequest);
            getFooterRepository().save(footerImg);
            responseEntity = new ResponseEntity<>(FooterResponse.from(footerImg), HttpStatus.OK);

        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    public ResponseEntity<?> getFooterByFoto(String foto){
        ResponseEntity<?> responseEntity;
        FooterImg footerImg = getFooterRepository().findByFoto(foto);

        if (footerImg != null && !footerImg.getFoto().equals("")) {
            responseEntity = new ResponseEntity<>(FooterResponse.from(footerImg),HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    // (LOGICA DE DELETE por producto)
    public ResponseEntity<?> deleteFooterByFoto(String foto) {
        ResponseEntity<?> responseEntity;
        FooterImg footerImg = getFooterRepository().findByFoto(foto);
        if (footerImg != null && !footerImg.getFoto().equals("")) {
            getFooterRepository().delete(footerImg);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    //(LOGICA UPDATE)
    public ResponseEntity<?> updateFooter (FooterRequest footerRequest) {
        Optional<?> optional = getFooterRepository().findById(footerRequest.getId());
        ResponseEntity<?> responseEntity;
       FooterImg footerImg;
        if (optional.isPresent()){
            if (footerRequest.getFoto()!= null &&
                    !footerRequest.getFoto().equals("")){
                    footerImg = FooterImg.from(footerRequest);
                getFooterRepository().save(footerImg);
                responseEntity = new ResponseEntity<>(FooterResponse.from(footerImg), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
