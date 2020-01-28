package com.isaackennedy.shrinker.domain;

import com.isaackennedy.shrinker.domain.enums.PerfisUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Usuario extends GenericDomainUnit implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String nome;

    @Column
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<URL> urlsEncurtadas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario() { addPerfil(PerfisUsuario.USER); }

    public Usuario(Long id, String email, String nome, String senha) {
        super();
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        addPerfil(PerfisUsuario.USER);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<PerfisUsuario> getPerfis() {
        return perfis.stream().map(PerfisUsuario::toEnum).collect(Collectors.toSet());
    }

    public void addPerfil(PerfisUsuario perfil) {
        perfis.add(perfil.getCod());
    }
}
