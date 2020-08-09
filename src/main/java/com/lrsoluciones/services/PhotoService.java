package com.lrsoluciones.services;

import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.models.Photo;
import com.lrsoluciones.repositories.PhotoRepository;
import com.lrsoluciones.resources.request.CategoriaRequest;
import com.lrsoluciones.resources.request.PhotoRequest;
import com.lrsoluciones.resources.response.CategoriaResponse;
import com.lrsoluciones.resources.response.PhotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    private PhotoRepository getPhotoRepository() {
        return photoRepository;
    }

    public ResponseEntity<?> savePhotoBBDD(PhotoRequest photoRequest){// va a recibir el ItemRequest
        ResponseEntity<?> responseEntity;
        Photo photo;
        photo = getPhotoRepository().findByPath(photoRequest.getPath());
        if (photo==null) { // busaca por categoria y si no existe la crea!!! asi no repite la misma categoria

            if (photoRequest.getPath()!=null && !photoRequest.getPath().equals("")){
                photo = Photo.from(photoRequest);
                getPhotoRepository().save(photo);
                responseEntity = new ResponseEntity<>(PhotoResponse.from(photo), HttpStatus.OK);

            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
        // devuelve un ItemResponse, porque siempre que guardo algo en la bbdd necesito obtener un objeto de respuesta
    }

    public ResponseEntity<?> savePhotoFile(MultipartFile file){// va a recibir el ItemRequest
        ResponseEntity<?> responseEntity;

        if (file!=null) { // busaca por categoria y si no existe la crea!!! asi no repite la misma categoria

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(System.getProperty("user.home"));
                stringBuilder.append(File.separator);
                stringBuilder.append("Desktop");
                stringBuilder.append(File.separator);
                stringBuilder.append("LRSoluciones");
                stringBuilder.append(File.separator);
                stringBuilder.append("LRSoluciones");
                stringBuilder.append(File.separator);
                stringBuilder.append("src");
                stringBuilder.append(File.separator);
                stringBuilder.append("assets");
                stringBuilder.append(File.separator);
                stringBuilder.append("uploadsIMG");
                stringBuilder.append(File.separator);
                stringBuilder.append(file.getOriginalFilename());

                PhotoRequest photoRequest = new PhotoRequest(stringBuilder.toString());
                Photo photo = Photo.from(photoRequest);

            try {
                byte[] fileBytes = file.getBytes();
                Path path = Paths.get(stringBuilder.toString());
                Files.write(path, fileBytes);
                getPhotoRepository().save(photo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            responseEntity = new ResponseEntity<>(HttpStatus.OK);

        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
        // devuelve un ItemResponse, porque siempre que guardo algo en la bbdd necesito obtener un objeto de respuesta
    }

}
