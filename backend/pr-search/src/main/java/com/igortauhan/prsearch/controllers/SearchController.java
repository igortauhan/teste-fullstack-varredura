package com.igortauhan.prsearch.controllers;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<GenericRequestClass> search(@RequestParam Long ativoId, @RequestParam String pattern) {
        GenericRequestClass genericRequestClass = searchService.search(pattern, ativoId);
        return ResponseEntity.ok(genericRequestClass);
    }
}
