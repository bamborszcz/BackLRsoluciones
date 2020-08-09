package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.PortadaWebRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "portadaWeb")
public class PortadaWeb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "foto_web")
    private String fotoWeb;
    @Column(name = "responsivo", length = 5)
    private String responsivo;

    public PortadaWeb() {
    }

    public PortadaWeb(Long id, String fotoWeb, String responsivo) {
        this.id = id;
        this.fotoWeb = fotoWeb;
        this.responsivo = responsivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFotoWeb() {
        return fotoWeb;
    }

    public void setFotoWeb(String fotoWeb) {
        this.fotoWeb = fotoWeb;
    }

    public String getResponsivo() {
        return responsivo;
    }

    public void setResponsivo(String responsivo) {
        this.responsivo = responsivo;
    }

    public static PortadaWeb from (PortadaWebRequest portadaWebRequest) {
        return new PortadaWeb(portadaWebRequest.getId(), portadaWebRequest.getFotoWeb(), portadaWebRequest.getResponsivo());
    }
}
