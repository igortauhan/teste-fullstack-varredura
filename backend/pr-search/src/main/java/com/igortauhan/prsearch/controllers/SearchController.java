package com.igortauhan.prsearch.controllers;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.services.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/search")
@Api(value = "API Rest para buscas na API externa da INTX. Faz requisicao no RecordsController do projeto pr-base")
@CrossOrigin(origins = "*")
public class SearchController {

    private static Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    @ApiOperation(value = "Retorna um GenericRequestClass que contem uma lista de Records")
    @ApiParam(value = "Recebe um ID do Ativo respectivo a consulta e o Email ou Domain desse Ativo")
    @ApiResponse(message = "Ok", code = 200)
    public ResponseEntity<GenericRequestClass> search(@RequestParam Long ativoId, @RequestParam String pattern) {
        logger.info("Recebido requisicao GET no endpoint /search");
        logger.info("ID do ativo recebido: {}", ativoId);
        logger.info("Padrao de pesquisa recebido: {}", pattern);
        GenericRequestClass genericRequestClass = searchService.search(pattern, ativoId);
        return ResponseEntity.ok(genericRequestClass);
    }
}
