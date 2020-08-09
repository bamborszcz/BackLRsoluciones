package com.lrsoluciones.resources.request;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class PortadaWebRequest {


    @JsonProperty("codigo")
    private Long id;
    @NotNull
    @JsonProperty("fotoWeb")
    private String fotoWeb;
    @NotNull
    @JsonProperty("responsivo")
    private String responsivo;

    @JsonCreator
    public PortadaWebRequest(@JsonProperty("codigo") Long id,
                             @JsonProperty("fotoWeb") String fotoWeb,
                             @JsonProperty("responsivo") String responsivo) {
        this.id = id;
        this.fotoWeb = fotoWeb;
        this.responsivo = responsivo;
    }

    public Long getId() {
        return id;
    }

    public String getFotoWeb() {
        return fotoWeb;
    }

    public String getResponsivo() {
        return responsivo;
    }
}
