package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.ProductoRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "categoria",referencedColumnName = "categoria")
    private Categoria categoria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "producto", length = 25)
    private String producto;
    @Column(name = "foto")
    private String foto;

    public Producto() {
    }

    public Producto(Long id, Categoria categoria, String descripcion, String producto, String foto) {
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

    public void setproducto(String producto) {
        this.producto = producto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public static Producto from (ProductoRequest productoRequest) {
        return new Producto(productoRequest.getId(),productoRequest.getCategoria(),productoRequest.getDescripcion(),
                productoRequest.getproducto(), productoRequest.getFoto());
    }
}
