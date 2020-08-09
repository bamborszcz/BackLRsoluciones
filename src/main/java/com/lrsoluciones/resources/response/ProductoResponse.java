package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.Categoria;
import com.lrsoluciones.models.Producto;

public class ProductoResponse {

    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("categoria")
    private Categoria categoria;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("producto")
    private String producto;
    @JsonProperty("foto")
    private String foto;

    public ProductoResponse() {
    }

    public ProductoResponse(Long id, Categoria categoria, String descripcion, String producto, String foto) {
        this.id = id;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.producto = producto;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public static ProductoResponse from (Producto producto) {
        return new ProductoResponse(producto.getId(), producto.getCategoria(), producto.getDescripcion(),
                producto.getProducto(),producto.getFoto());
    }

}
