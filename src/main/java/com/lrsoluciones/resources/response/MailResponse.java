package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.FooterImg;
import com.lrsoluciones.models.Mail;
import com.sun.istack.NotNull;

public class MailResponse {
    @NotNull
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

    public MailResponse() {
    }

    public MailResponse(Long id, String nomAp, String mail, int tel, String localidad, String provincia, String comentario) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAp() {
        return nomAp;
    }

    public void setNomAp(String nomAp) {
        this.nomAp = nomAp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public static MailResponse from (Mail mail) {
        return new MailResponse(mail.getId(), mail.getNomAp(), mail.getMail(),
                mail.getTel(), mail.getLocalidad(), mail.getProvincia(), mail.getComentario());
    }
}
