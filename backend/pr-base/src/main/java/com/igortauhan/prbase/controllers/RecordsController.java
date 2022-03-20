package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.Records;
import com.igortauhan.prbase.services.RecordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordsController {

    private static Logger logger = LoggerFactory.getLogger(RecordsController.class);
    private final RecordsService recordsService;

    public RecordsController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @PostMapping
    public ResponseEntity<List<Records>> insert(@RequestBody String recordsJson, @RequestParam Long ativoId) {
        logger.info("Requisicao recebida no endpoint /records");
        logger.info("ID do Ativo a ser registrado na consulta: {}", ativoId);
        List<Records> records = recordsService.insert(recordsJson, ativoId);
        return ResponseEntity.ok(records);
    }
}
