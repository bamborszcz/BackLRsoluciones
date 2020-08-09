package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.Categoria;
import com.sun.istack.NotNull;

public class CategoriaResponse {

    @NotNull
    @JsonProperty("codigo")
    private Long id = null;
    @NotNull
    @JsonProperty("categoria")
    private String categoria  = null;

    public CategoriaResponse() {
    }

    public CategoriaResponse(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static CategoriaResponse from (Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getCategoria());
    }
}
