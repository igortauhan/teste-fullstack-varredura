package com.igortauhan.prsearch.services;

import com.igortauhan.prsearch.models.GenericRequestClass;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private final RequestService requestService;

    public SearchService(RequestService requestService, RestTemplateBuilder restTemplateBuilder) {
        this.requestService = requestService;
    }

    public GenericRequestClass search(String pattern) {
        return requestService.search(pattern);
    }
}
