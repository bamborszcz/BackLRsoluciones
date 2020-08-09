package com.lrsoluciones.resources.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class PortadaCelRequest {

    @JsonProperty("codigo")
    private Long id;
    @NotNull
    @JsonProperty("fotoCel")
    private String fotoCel;
    @NotNull
    @JsonProperty("responsivo")
    private String responsivo;

    @JsonCreator
    public PortadaCelRequest(@JsonProperty("codigo") Long id,
                             @JsonProperty("fotoCel") String fotoCel,
                             @JsonProperty("responsivo") String responsivo) {
        this.id = id;
        this.fotoCel = fotoCel;
        this.responsivo = responsivo;
    }

    public Long getId() {
        return id;
    }

    public String getFotoCel() {
        return fotoCel;
    }

    public String getResponsivo() {
        return responsivo;
    }
}
