package com.lrsoluciones.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lrsoluciones.models.Photo;
import com.sun.istack.NotNull;

public class PhotoResponse {

    @NotNull
    @JsonProperty("codigo")
    private Long id = null;
    @NotNull
    @JsonProperty("path")
    private String path  = null;

    public PhotoResponse() {
    }

    public PhotoResponse(Long id, String path) {
        this.id = id;
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

    public static PhotoResponse from (Photo photo) {
        return new PhotoResponse(photo.getId(), photo.getPath());
    }
}
