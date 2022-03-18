package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.services.AtivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ativos")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping
    public ResponseEntity<List<Ativo>> findAll() {
        List<Ativo> ativos = ativoService.findAll();
        return ResponseEntity.ok(ativos);
    }

    @PostMapping
    public ResponseEntity<Ativo> insert(@RequestBody Ativo ativo) {
        ativo = ativoService.insert(ativo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(ativo.getId()).toUri();
        return ResponseEntity.created(uri).body(ativo);
    }
}
