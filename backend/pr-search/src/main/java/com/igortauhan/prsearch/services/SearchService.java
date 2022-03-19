package com.igortauhan.prsearch.services;

import com.igortauhan.prsearch.config.GsonConfig;
import com.igortauhan.prsearch.feign.RecordsFeignClient;
import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.models.Records;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final RequestService requestService;
    private final GsonConfig gsonConfig;
    private final RecordsFeignClient recordsFeignClient;

    public SearchService(RequestService requestService, GsonConfig gsonConfig, RecordsFeignClient recordsFeignClient) {
        this.requestService = requestService;
        this.gsonConfig = gsonConfig;
        this.recordsFeignClient = recordsFeignClient;
    }

    public GenericRequestClass search(String pattern, Long ativoId) {
        GenericRequestClass genericRequestClass = requestService.search(pattern);
        List<Records> records = insertRecord(genericRequestClass, ativoId);
        return genericRequestClass;
    }

    private List<Records> insertRecord(GenericRequestClass genericRequestClass, Long ativoId) {
        String recordsJson = gsonConfig.gson().toJson(genericRequestClass, GenericRequestClass.class);
        return recordsFeignClient.insert(recordsJson, ativoId).getBody();
    }
}
