package com.igortauhan.prbase.services;

import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.models.dto.AtivoDto;
import com.igortauhan.prbase.repositories.AtivoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    public Page<AtivoDto> findAll(Pageable pageable) {
        Page<Ativo> ativos = ativoRepository.findAll(pageable);
        return ativos.map(AtivoDto::new);
    }

    public AtivoDto findById(Long id) {
        Optional<Ativo> ativo = ativoRepository.findById(id);
        return new AtivoDto(ativo.orElseThrow(
                () -> new RuntimeException("Ativo não encontrado! Id: " + id)
        ));
    }

    public AtivoDto findByEmail(String email) {
        Optional<Ativo> ativo = ativoRepository.findAtivoByEmail(email);
        return new AtivoDto(ativo.orElseThrow(
                () -> new RuntimeException("Ativo não encontrado! Email: " + email)
        ));
    }

    public AtivoDto findByDomain(String domain) {
        Optional<Ativo> ativo = ativoRepository.findAtivoByDomain(domain);
        return new AtivoDto(ativo.orElseThrow(
                () -> new RuntimeException("Ativo não encontrado! Email: " + domain)
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

    public void delete(Long id) {
        findById(id);
        ativoRepository.deleteById(id);
    }

    public Ativo fromDto(AtivoDto ativoDto) {
        return new Ativo(
                ativoDto.getId(),
                ativoDto.getName(),
                ativoDto.getEmail(),
                ativoDto.getDomain()
        );
    }
}
