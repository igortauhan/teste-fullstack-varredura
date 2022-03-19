package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.Records;
import com.igortauhan.prbase.services.RecordsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordsController {

    private final RecordsService recordsService;

    public RecordsController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @PostMapping
    public ResponseEntity<List<Records>> insert(@RequestBody String recordsJson, @RequestParam Long ativoId) {
        List<Records> records = recordsService.insert(recordsJson, ativoId);
        return ResponseEntity.ok(records);
    }
}
