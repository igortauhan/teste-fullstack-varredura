package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.dto.AtivoDto;
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
    public ResponseEntity<List<AtivoDto>> findAll() {
        List<AtivoDto> ativos = ativoService.findAll();
        return ResponseEntity.ok(ativos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AtivoDto> findById(@PathVariable Long id) {
        AtivoDto ativoDto = ativoService.findById(id);
        return ResponseEntity.ok(ativoDto);
    }

    @GetMapping(value = "/email")
    public ResponseEntity<AtivoDto> findByEmail(@RequestParam("email") String email) {
        AtivoDto ativoDto = ativoService.findByEmail(email);
        return ResponseEntity.ok(ativoDto);
    }

    @GetMapping(value = "/domain")
    public ResponseEntity<AtivoDto> findByDomain(@RequestParam("domain") String domain) {
        AtivoDto ativoDto = ativoService.findByDomain(domain);
        return ResponseEntity.ok(ativoDto);
    }

    @PostMapping
    public ResponseEntity<AtivoDto> insert(@RequestBody AtivoDto ativoDto) {
        ativoDto = ativoService.insert(ativoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(ativoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(ativoDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AtivoDto> update(@RequestBody AtivoDto ativoDto, @PathVariable Long id) {
        ativoDto = ativoService.update(ativoDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ativoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
