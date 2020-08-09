package com.lrsoluciones.resources;

import com.lrsoluciones.services.PhotoService;
import com.lrsoluciones.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("photos")
public class PhotoResource {

    private final PhotoService photoService;

    @Autowired
    public PhotoResource(PhotoService photoService) {
        this.photoService = photoService;
    }

    private PhotoService getPhotoService() {
        return photoService;
    }

    //(POST)
    @CrossOrigin(origins = "http://localhost:4200") // asi le doy permiso a mi servidor!!
    @PostMapping("/fd")
    public @ResponseBody
    ResponseEntity<?> savePhotoFile(@RequestParam("file") MultipartFile file){
        return getPhotoService().savePhotoFile(file);
    }

}
