package com.igortauhan.prbase.models.dto;

import com.igortauhan.prbase.models.Ativo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtivoDto {

    private Long id;

    @NotNull(message = "Atributo name é obrigatório")
    @NotEmpty(message = "Atributo name é obrigatório")
    private String name;

    @NotNull(message = "Atributo email é obrigatório")
    @NotEmpty(message = "Atributo email é obrigatório")
    private String email;

    @NotNull(message = "Atributo domain é obrigatório")
    @NotEmpty(message = "Atributo domain é obrigatório")
    private String domain;

    public AtivoDto() {

    }

    public AtivoDto(Ativo ativo) {
        id = ativo.getId();
        name = ativo.getName();
        email = ativo.getEmail();
        domain = ativo.getDomain();
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
