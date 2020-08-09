package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.PortadaWeb;

public class PortadaWebResponse {

    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("fotoWeb")
    private String fotoWeb;
    @JsonProperty("responsivo")
    private String responsivo;

    public PortadaWebResponse() {
    }

    public PortadaWebResponse(Long id, String fotoWeb, String responsivo) {
        this.id = id;
        this.fotoWeb = fotoWeb;
        this.responsivo = responsivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFotoWeb() {
        return fotoWeb;
    }

    public void setFotoWeb(String fotoWeb) {
        this.fotoWeb = fotoWeb;
    }

    public String getResponsivo() {
        return responsivo;
    }

    public void setResponsivo(String responsivo) {
        this.responsivo = responsivo;
    }

    public static PortadaWeb from (PortadaWeb portadaWeb) {
        return new PortadaWeb(portadaWeb.getId(), portadaWeb.getFotoWeb(), portadaWeb.getResponsivo());
    }
}
