package com.lrsoluciones.models;

import com.lrsoluciones.resources.request.PhotoRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photo")
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@OneToOne()
    //@JoinColumn(name = "foto")
    @Column(name = "path")
    private String path;

    public Photo() {
    }

    public Photo(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public static Photo from (PhotoRequest photoRequest) {
        return new Photo(photoRequest.getPath());
    }

}
