package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.Records;
import com.igortauhan.prbase.services.RecordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/records")
@Api(value = "API Rest do historico de consultas de vazamento dos Ativos")
@CrossOrigin(origins = "*")
public class RecordsController {

    private static Logger logger = LoggerFactory.getLogger(RecordsController.class);
    private final RecordsService recordsService;

    public RecordsController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Records>> getAllRecordsByAtivoId(@PathVariable Long id) {
        List<Records> records = recordsService.getAllRecordsByAtivoId(id);
        return ResponseEntity.ok(records);
    }

    @PostMapping
    @ApiOperation("Retorna uma lista de Records")
    @ApiParam("Recebe um Json serializado de uma Classe Record pelo Body da requisicao e um ID Long do Ativo respectivo a consulta")
    @ApiResponse(message = "Ok", code = 200)
    public ResponseEntity<List<Records>> insert(@RequestBody String recordsJson, @RequestParam Long ativoId) {
        logger.info("Requisicao recebida no endpoint /records");
        logger.info("ID do Ativo a ser registrado na consulta: {}", ativoId);
        List<Records> records = recordsService.insert(recordsJson, ativoId);
        return ResponseEntity.ok(records);
    }
}
