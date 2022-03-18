package com.igortauhan.prbase.services;

import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.models.dto.AtivoDto;
import com.igortauhan.prbase.repositories.AtivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    public List<AtivoDto> findAll() {
        List<Ativo> ativos = ativoRepository.findAll();
        return ativos.stream().map(AtivoDto::new).collect(Collectors.toList());
    }

    public AtivoDto insert(Ativo ativo) {
        ativo.setId(null);
        ativo = ativoRepository.save(ativo);
        return new AtivoDto(ativo);
    }
}
