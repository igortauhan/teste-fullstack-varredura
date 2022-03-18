package com.igortauhan.prbase.models;

import javax.persistence.*;

@Entity()
@Table(name = "tb_ativos")
public class Ativo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String domain;

    public Ativo() {

    }

    public Ativo(Long id, String nome, String email, String dominio) {
        this.id = id;
        this.name = nome;
        this.email = email;
        this.domain = dominio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
