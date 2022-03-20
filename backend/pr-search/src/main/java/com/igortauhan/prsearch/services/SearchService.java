package com.igortauhan.prsearch.services;

import com.igortauhan.prsearch.config.GsonConfig;
import com.igortauhan.prsearch.feign.RecordsFeignClient;
import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.models.Records;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private static Logger logger = LoggerFactory.getLogger(SearchService.class);
    private final RequestService requestService;
    private final GsonConfig gsonConfig;
    private final RecordsFeignClient recordsFeignClient;

    public SearchService(RequestService requestService, GsonConfig gsonConfig, RecordsFeignClient recordsFeignClient) {
        this.requestService = requestService;
        this.gsonConfig = gsonConfig;
        this.recordsFeignClient = recordsFeignClient;
    }

    public GenericRequestClass search(String pattern, Long ativoId) {
        logger.info("Fazendo requisicao para a API externa da INTX...");
        GenericRequestClass genericRequestClass = requestService.search(pattern);
        List<Records> records = insertRecord(genericRequestClass, ativoId);
        return genericRequestClass;
    }

    private List<Records> insertRecord(GenericRequestClass genericRequestClass, Long ativoId) {
        String recordsJson = gsonConfig.gson().toJson(genericRequestClass, GenericRequestClass.class);
        logger.info("Fazendo requisicao no FeignClient do endpoint /records no projeto pr-base");
        logger.info("ID do Ativo a ser registrado a consulta: {}", ativoId);
        return recordsFeignClient.insert(recordsJson, ativoId).getBody();
    }
}
