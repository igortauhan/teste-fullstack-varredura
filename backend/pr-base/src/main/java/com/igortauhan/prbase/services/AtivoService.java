package com.igortauhan.prbase.services;

import com.igortauhan.prbase.repositories.AtivoRepository;
import org.springframework.stereotype.Service;

@Service
public class AtivoService {

    private AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }
}
