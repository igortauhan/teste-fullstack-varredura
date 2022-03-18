package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.services.AtivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ativos")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping()
    public ResponseEntity<List<Ativo>> findAll() {
        List<Ativo> ativos = ativoService.findAll();
        return ResponseEntity.ok(ativos);
    }
}
