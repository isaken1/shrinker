package com.isaackennedy.shrinker.dto;

import com.isaackennedy.shrinker.domain.URL;

import java.io.Serializable;

public class UrlDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String urlOriginal;
    private String urlEncurtada;

    public UrlDTO() {}

    public UrlDTO(URL url) {
        this.urlOriginal = url.getUrlOriginal();
        this.urlEncurtada = url.getUrlEncurtada();
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }
}
