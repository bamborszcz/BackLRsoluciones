package com.lrsoluciones.services;

import com.lrsoluciones.models.PortadaWeb;
import com.lrsoluciones.repositories.PortadaWebRepository;
import com.lrsoluciones.resources.request.PortadaWebRequest;
import com.lrsoluciones.resources.response.PortadaWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortadaWebService {

    private final PortadaWebRepository portadaWebRepository;

    @Autowired
    public PortadaWebService(PortadaWebRepository portadaWebRepository) {
        this.portadaWebRepository = portadaWebRepository;
    }

    public PortadaWebRepository getPortadaWebRepository() {
        return portadaWebRepository;
    }

    //(POST)
    public ResponseEntity<?> savePortadaWeb(PortadaWebRequest portadaWebRequest){
        ResponseEntity<?> responseEntity;
        PortadaWeb portadaWeb;
        if (portadaWebRequest.getFotoWeb()!=null &&
                !portadaWebRequest.getFotoWeb().equals("") &&
                portadaWebRequest.getResponsivo()!= null &&
                !portadaWebRequest.getResponsivo().equals("")){
            portadaWeb = PortadaWeb.from(portadaWebRequest);
            getPortadaWebRepository().save(portadaWeb);
            responseEntity = new ResponseEntity<>(PortadaWebResponse.from(portadaWeb), HttpStatus.OK);

        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //trae la foto para web
    public ResponseEntity<?> getPortadaById(Long id){
        ResponseEntity<?> responseEntity;
        Optional <PortadaWeb> portadaWeb = getPortadaWebRepository().findById(id);

        if (portadaWeb.isPresent() && !portadaWeb.get().getFotoWeb().equals("")) {
            responseEntity = new ResponseEntity<>(PortadaWebResponse.from(portadaWeb.get()),HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    // (LOGICA DE DELETE por portadaWeb)
    public ResponseEntity<?> deletePortadaByFotoWeb(String fotoWeb) {
        ResponseEntity<?> responseEntity;
        PortadaWeb portadaWeb = getPortadaWebRepository().findByFotoWeb(fotoWeb);
        if (portadaWeb != null && !portadaWeb.getFotoWeb().equals("")) {
            getPortadaWebRepository().delete(portadaWeb);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    //(LOGICA UPDATE web)
    public ResponseEntity<?> updatePortadaWeb (PortadaWebRequest portadaWebRequest) {
        Optional<?> optional = getPortadaWebRepository().findById(portadaWebRequest.getId());
        ResponseEntity<?> responseEntity;
        PortadaWeb portadaWeb;
        if (optional.isPresent()){
            if (portadaWebRequest.getFotoWeb()!= null &&
                    !portadaWebRequest.getFotoWeb().equals("")){
                portadaWeb = PortadaWeb.from(portadaWebRequest);
                getPortadaWebRepository().save(portadaWeb);
                responseEntity = new ResponseEntity<>(PortadaWebResponse.from(portadaWeb), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}
