package com.lrsoluciones.resources.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


public class MailRequest {

    @JsonProperty("codigo")
    private Long id;
    @NotNull
    @JsonProperty("nombre")
    private String nomAp;
    @NotNull
    @JsonProperty("mail")
    private String mail;
    @NotNull
    @JsonProperty("telefono")
    private int tel;
    @NotNull
    @JsonProperty("localidad")
    private String localidad;
    @NotNull
    @JsonProperty("provincia")
    private String provincia;
    @NotNull
    @JsonProperty("comentario")
    private String comentario;

    @JsonCreator
    public MailRequest(@JsonProperty Long id,
                       @JsonProperty String nomAp,
                       @JsonProperty String mail,
                       @JsonProperty int tel,
                       @JsonProperty String localidad,
                       @JsonProperty String provincia,
                       @JsonProperty String comentario) {
        this.id = id;
        this.nomAp = nomAp;
        this.mail = mail;
        this.tel = tel;
        this.localidad = localidad;
        this.provincia = provincia;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public String getNomAp() {
        return nomAp;
    }

    public String getMail() {
        return mail;
    }

    public int getTel() {
        return tel;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getComentario() {
        return comentario;
    }
}
