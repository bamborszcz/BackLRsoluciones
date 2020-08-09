package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.FooterRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "footer")
public class FooterImg implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "foto",nullable = false)
    private String foto;

    public FooterImg() {
    }

    public FooterImg(Long id, String foto) {
        this.id = id;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public static FooterImg from (FooterRequest footerRequest) {
        return new FooterImg(footerRequest.getId(),footerRequest.getFoto());
    }
}
