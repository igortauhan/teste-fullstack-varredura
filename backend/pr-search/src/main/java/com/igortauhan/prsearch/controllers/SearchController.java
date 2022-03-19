package com.igortauhan.prsearch.controllers;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<GenericRequestClass> search(@RequestParam String pattern) {
        GenericRequestClass genericRequestClass = searchService.search(pattern);
        return ResponseEntity.ok(genericRequestClass);
    }
}
