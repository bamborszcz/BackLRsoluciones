package com.lrsoluciones.resources.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class PhotoRequest {

    @NotNull
    @JsonProperty("path")
    private String path;

    @JsonCreator
    public PhotoRequest(@JsonProperty("path") String path) {

        this.path = path;
    }



    public String getPath() {
        return path;
    }
}
