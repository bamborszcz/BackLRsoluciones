package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.PortadaCelRequest;
import com.lrsoluciones.resources.request.PortadaWebRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "portadaCel")
public class PortadaCel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "foto_cel")
    private String fotoCel;
    @Column(name = "responsivo", length = 5)
    private String responsivo;

    public PortadaCel() {
    }

    public PortadaCel(Long id, String fotoCel, String responsivo) {
        this.id = id;
        this.fotoCel = fotoCel;
        this.responsivo = responsivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsivo() {
        return responsivo;
    }

    public void setResponsivo(String responsivo) {
        this.responsivo = responsivo;
    }

    public String getFotoCel() {
        return fotoCel;
    }

    public void setFotoCel(String fotoCel) {
        this.fotoCel = fotoCel;
    }

    public static PortadaCel from (PortadaCelRequest portadaCelRequest) {
        return new PortadaCel(portadaCelRequest.getId(), portadaCelRequest.getFotoCel(), portadaCelRequest.getResponsivo());
    }
}
