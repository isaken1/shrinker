package com.isaackennedy.shrinker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class URL extends GenericDomainUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonIgnore
    private Usuario usuario;

    private String urlOriginal;
    private String urlEncurtada;

    public URL() {}

    public URL(Long id, Date dataCriacao, Usuario usuario, String urlOriginal, String urlEncurtada) {
        super(id);
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.urlOriginal = urlOriginal;
        this.urlEncurtada = urlEncurtada;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
