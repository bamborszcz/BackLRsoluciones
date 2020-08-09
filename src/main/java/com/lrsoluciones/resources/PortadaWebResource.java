package com.lrsoluciones.resources;

import com.lrsoluciones.resources.request.PortadaWebRequest;
import com.lrsoluciones.services.PortadaWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("portadaWeb")
public class PortadaWebResource {

    private final PortadaWebService portadaWebService;

    @Autowired
    public PortadaWebResource(PortadaWebService portadaWebService) {
        this.portadaWebService = portadaWebService;
    }

    private PortadaWebService getPortadaWebService() {
        return portadaWebService;
    }

    //(POST)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<?> savePortadaWeb(@RequestBody @Valid PortadaWebRequest portadaWebRequest){
        return getPortadaWebService().savePortadaWeb(portadaWebRequest);
    }

    //(GET Footer POR Foto)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{fotoWeb}" ,produces = "application/json")
    public @ResponseBody ResponseEntity<?> getPortadaByFotoWeb(@PathVariable("fotoWeb") Long id){ // @ResponseBody significa que es el cuerpo de la respuesta
        return getPortadaWebService().getPortadaById(id);
    }


    @DeleteMapping(value = "/{fotoWeb}",produces = "application/json")
    public @ResponseBody ResponseEntity<?> deletePortadaWeb(@PathVariable("fotoWeb") String fotoWeb) {
        return getPortadaWebService().deletePortadaByFotoWeb(fotoWeb);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")// produce y consume un json
    public @ResponseBody ResponseEntity<?> updatePortadaWeb(@RequestBody PortadaWebRequest portadaWebRequest) {
        return getPortadaWebService().updatePortadaWeb(portadaWebRequest);
    }
}
