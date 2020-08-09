package com.lrsoluciones.resources.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


public class CategoriaRequest {

    @JsonProperty("codigo")
    private Long id;
    @NotNull
    @JsonProperty("categoria")
    private String categoria;

    @JsonCreator
    public CategoriaRequest(@JsonProperty("codigo") Long id,
                            @JsonProperty("categoria") String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }
}
