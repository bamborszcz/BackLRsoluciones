package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.FooterImg;
import com.lrsoluciones.models.Producto;

public class FooterResponse {

    @JsonProperty("codigo")
    private Long id;
    @JsonProperty("foto")
    private String foto;

    public FooterResponse() {
    }

    public FooterResponse(Long id, String foto) {
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


    public static FooterResponse from (FooterImg footerImg) {
        return new FooterResponse(footerImg.getId(), footerImg.getFoto());
    }
}
