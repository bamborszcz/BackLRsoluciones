package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.PortadaCel;
import com.lrsoluciones.models.PortadaWeb;

public class PortadaCelResponse {


    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("fotoCel")
    private String fotoCel;
    @JsonProperty("responsivo")
    private String responsivo;

    public PortadaCelResponse() {
    }

    public PortadaCelResponse(Long id, String fotoCel, String responsivo) {
        this.id = id;
        this.fotoCel = fotoCel;
        this.responsivo = responsivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFotoCel() {
        return fotoCel;
    }

    public void setFotoCel(String fotoCel) {
        this.fotoCel = fotoCel;
    }

    public String getResponsivo() {
        return responsivo;
    }

    public void setResponsivo(String responsivo) {
        this.responsivo = responsivo;
    }

    public static PortadaCel from (PortadaCel portadaCel) {
        return new PortadaCel(portadaCel.getId(), portadaCel.getFotoCel(), portadaCel.getResponsivo());
    }
}
