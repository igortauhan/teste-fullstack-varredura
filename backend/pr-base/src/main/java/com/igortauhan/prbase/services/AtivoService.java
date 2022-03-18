package com.igortauhan.prbase.services;

import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.repositories.AtivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    public List<Ativo> findAll() {
         return ativoRepository.findAll();
    }
}
