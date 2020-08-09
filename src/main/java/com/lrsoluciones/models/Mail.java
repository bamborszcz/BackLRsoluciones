package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.MailRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mail")
public class Mail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "nombre")
     private String nomAp;
    @Column(name = "mail")
    private String mail;
    @Column(name = "telefono")
    private int tel;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "comentario")
    private String comentario;

    public Mail() {
    }

    public Mail(Long id, String nomAp, String mail, int tel, String localidad, String provincia, String comentario) {
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

    public static Mail from (MailRequest mailRequest) {
        return new Mail(mailRequest.getId(), mailRequest.getNomAp(), mailRequest.getMail(),
                mailRequest.getTel(), mailRequest.getLocalidad(), mailRequest.getProvincia(),mailRequest.getComentario());
    }
}
