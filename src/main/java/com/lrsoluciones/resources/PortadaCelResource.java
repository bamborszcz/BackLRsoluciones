package com.lrsoluciones.resources;

import com.lrsoluciones.models.PortadaCel;
import com.lrsoluciones.resources.request.PortadaCelRequest;
import com.lrsoluciones.resources.request.PortadaWebRequest;
import com.lrsoluciones.services.PortadaCelService;
import com.lrsoluciones.services.PortadaWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("portadaCel")
public class PortadaCelResource {

    private final PortadaCelService portadaCelService;

    @Autowired
    public PortadaCelResource(PortadaCelService portadaCelService) {
        this.portadaCelService = portadaCelService;
    }

    private PortadaCelService getPortadaCelService() {
        return portadaCelService;
    }


    //(POST)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<?> savePortadaCel(@RequestBody @Valid PortadaCelRequest portadaCelRequest){
        return getPortadaCelService().savePortadaCel(portadaCelRequest);
    }

    //(GET Footer POR Foto)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{fotoCel}" ,produces = "application/json")
    public @ResponseBody ResponseEntity<?> getPortadaByFotoCel(@PathVariable("fotoCel") Long id){ // @ResponseBody significa que es el cuerpo de la respuesta
        return getPortadaCelService().getPortadaById(id);
    }

    @DeleteMapping(value = "/{fotoCel}",produces = "application/json")
    public @ResponseBody ResponseEntity<?> deletePortadaCel(@PathVariable("fotoCel") String fotoCel) {
        return getPortadaCelService().deletePortadaByFotoCel(fotoCel);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")// produce y consume un json
    public @ResponseBody ResponseEntity<?> updatePortadaCel(@RequestBody PortadaCelRequest portadaCelRequest) {
        return getPortadaCelService().updatePortadaCel(portadaCelRequest);
    }
}
