package com.lrsoluciones.resources.request;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.Categoria;
import com.sun.istack.NotNull;

public class ProductoRequest {

    @JsonProperty("codigo")
    private Long id;
    @NotNull
    @JsonProperty("categoria")
    private Categoria categoria;
    @NotNull
    @JsonProperty("descripcion")
    private String descripcion;
    @NotNull
    @JsonProperty("producto")
    private String producto;
    @NotNull
    @JsonProperty("foto")
    private String foto;

    @JsonCreator
    public ProductoRequest(@JsonProperty("codigo") Long id,
                           @JsonProperty("categoria") Categoria categoria,
                           @JsonProperty("descripcion") String descripcion,
                           @JsonProperty("producto") String producto,
                           @JsonProperty("foto") String foto) {
        this.id = id;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.producto = producto;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getproducto() {
        return producto;
    }

    public String getFoto() {
        return foto;
    }
}
