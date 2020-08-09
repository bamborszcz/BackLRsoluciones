package com.lrsoluciones.services;

import com.lrsoluciones.models.PortadaCel;
import com.lrsoluciones.models.PortadaWeb;
import com.lrsoluciones.repositories.PortadaCelRepository;
import com.lrsoluciones.resources.request.PortadaCelRequest;
import com.lrsoluciones.resources.request.PortadaWebRequest;
import com.lrsoluciones.resources.response.PortadaCelResponse;
import com.lrsoluciones.resources.response.PortadaWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortadaCelService {

    private final PortadaCelRepository portadaCelRepository;

    @Autowired
    public PortadaCelService(PortadaCelRepository portadaCelRepository) {
        this.portadaCelRepository = portadaCelRepository;
    }

    public PortadaCelRepository getPortadaCelRepository() {
        return portadaCelRepository;
    }

    //(POST)
    public ResponseEntity<?> savePortadaCel(PortadaCelRequest portadaCelRequest){
        ResponseEntity<?> responseEntity;
        PortadaCel portadaCel;
        if (portadaCelRequest.getFotoCel()!=null &&
                !portadaCelRequest.getFotoCel().equals("") &&
                portadaCelRequest.getResponsivo()!= null &&
                !portadaCelRequest.getResponsivo().equals("")){
            portadaCel = PortadaCel.from(portadaCelRequest);
            getPortadaCelRepository().save(portadaCel);
            responseEntity = new ResponseEntity<>(PortadaCelResponse.from(portadaCel), HttpStatus.OK);

        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //trae la foto para web
    public ResponseEntity<?> getPortadaById(Long id){
        ResponseEntity<?> responseEntity;
        Optional <PortadaCel> portadaCel = getPortadaCelRepository().findById(id);

        if (portadaCel.isPresent() && !portadaCel.get().getFotoCel().equals("")) {
            responseEntity = new ResponseEntity<>(PortadaCelResponse.from(portadaCel.get()),HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    // (LOGICA DE DELETE por portadaCel)
    public ResponseEntity<?> deletePortadaByFotoCel(String fotoCel) {
        ResponseEntity<?> responseEntity;
        PortadaCel portadaCel = getPortadaCelRepository().findByFotoCel(fotoCel);
        if (portadaCel != null && !portadaCel.getFotoCel().equals("")) {
            getPortadaCelRepository().delete(portadaCel);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    //(LOGICA UPDATE web)
    public ResponseEntity<?> updatePortadaCel (PortadaCelRequest portadaCelRequest) {
        Optional<?> optional = getPortadaCelRepository().findById(portadaCelRequest.getId());
        ResponseEntity<?> responseEntity;
        PortadaCel portadaCel;
        if (optional.isPresent()){
            if (portadaCelRequest.getFotoCel()!= null &&
                    !portadaCelRequest.getFotoCel().equals("")){
                portadaCel = PortadaCel.from(portadaCelRequest);
                getPortadaCelRepository().save(portadaCel);
                responseEntity = new ResponseEntity<>(PortadaCelResponse.from(portadaCel), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}