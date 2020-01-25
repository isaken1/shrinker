package com.isaackennedy.shrinker.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario extends GenericDomainUnit implements Serializable {

    @Column(unique = true)
    private String email;

    private String nome;
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<URL> urlsEncurtadas;

    public Usuario() {}

    public Usuario(Long id, String email, String nome, String senha) {
        super(id);
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<URL> getUrlsEncurtadas() {
        return urlsEncurtadas;
    }

    public void setUrlsEncurtadas(List<URL> urlsEncurtadas) {
        this.urlsEncurtadas = urlsEncurtadas;
    }
}
