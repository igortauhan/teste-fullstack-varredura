package com.igortauhan.prsearch.controllers;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.services.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    private static Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<GenericRequestClass> search(@RequestParam Long ativoId, @RequestParam String pattern) {
        logger.info("Recebido requisicao GET no endpoint /search");
        logger.info("ID do ativo recebido: {}", ativoId);
        logger.info("Padrao de pesquisa recebido: {}", pattern);
        GenericRequestClass genericRequestClass = searchService.search(pattern, ativoId);
        return ResponseEntity.ok(genericRequestClass);
    }
}
