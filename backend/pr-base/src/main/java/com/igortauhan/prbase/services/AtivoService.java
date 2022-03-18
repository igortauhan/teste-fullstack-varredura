package com.igortauhan.prbase.services;

import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.models.dto.AtivoDto;
import com.igortauhan.prbase.repositories.AtivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public AtivoDto findById(Long id) {
        Optional<Ativo> ativo = ativoRepository.findById(id);
        return new AtivoDto(ativo.orElseThrow(
                () -> new RuntimeException("Ativo não encontrado! Id: " + id)
        ));
    }

    public AtivoDto insert(AtivoDto ativoDto) {
        Ativo ativo = fromDto(ativoDto);
        ativo.setId(null);
        ativo = ativoRepository.save(ativo);
        return new AtivoDto(ativo);
    }

    public AtivoDto update(AtivoDto ativoDto, Long id) {
        Ativo ativo = fromDto(ativoDto);
        ativo.setId(id);
        ativo = ativoRepository.save(ativo);
        return new AtivoDto(ativo);
    }

    private Ativo fromDto(AtivoDto ativoDto) {
        return new Ativo(
                ativoDto.getId(),
                ativoDto.getName(),
                ativoDto.getEmail(),
                ativoDto.getDomain()
        );
    }
}
