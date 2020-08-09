package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.CategoriaRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity// esto le dice a hibernate q mapee esta clase contra una tabla
@Table(name = "categorias") // esta es la tabla contra la q se va a mapear
public class Categoria implements Serializable { // esta interfaz hay que implementarla para traer objetos dentro de un objeto
    // es para usar many to one, ya no es necesario crear el post de categorias, lo hace solo cuando creamos el producto y le decimos a que categoria pertenece!!!

    //(identity) el id en ese campo lo ingresa la bbdd por un autonumerico
    //(auto)hibernate te genera el valor
    //(table) extrae el id de una tabla en la cual ya tengo un conjunto de numeros
    //(secuense) le tengo que decir el nombre exacto de la secuencia q quiero usar, pero mysql no tiene secuence
    @Id// esto significa q este atributo es el primary key en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)// la tabla misma tiene el id (IDENTITY), SI LE PONGO (AUTO) EL SISTEMA USA UNA CLAVE PROPIA DE EL
    @Column(name = "id",nullable = false)// le digo que en la tabla esta columna no admita valores nulos
    private Long id;
    @Column(name = "categoria", length = 25,nullable = false)// length es para darle el tamaño en caracteres
    private String categoria;

    public Categoria() {
    }

    public Categoria(Long id, String categoria) {
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

    public static Categoria from (CategoriaRequest categoriaRequest) {
        return new Categoria(categoriaRequest.getId(), categoriaRequest.getCategoria());
    }
}
