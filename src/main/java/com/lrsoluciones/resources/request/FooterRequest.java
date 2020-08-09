package com.lrsoluciones.resources.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


public class FooterRequest {

    @JsonProperty("codigo")
    private Long id;
    @NotNull
    @JsonProperty("foto")
    private String foto;

    @JsonCreator
    public FooterRequest(@JsonProperty("codigo") Long id,
                         @JsonProperty("foto") String foto) {
        this.id = id;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }
}
