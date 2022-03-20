package com.igortauhan.prsearch.services;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.models.intx.RequestBody;
import com.igortauhan.prsearch.models.intx.ResponseBodyRequest;
import com.igortauhan.prsearch.services.utils.PrepareRequestHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

    Logger logger = LoggerFactory.getLogger(RequestService.class);
    private final RestTemplate restTemplate;
    private final PrepareRequestHeaders prepareRequestHeaders;

    public RequestService(RestTemplateBuilder restTemplateBuilder, PrepareRequestHeaders prepareRequestHeaders) {
        this.restTemplate = restTemplateBuilder.build();
        this.prepareRequestHeaders = prepareRequestHeaders;
    }

    public GenericRequestClass search(String pattern) {
        // Pega o resultado do request na url de POST
        ResponseBodyRequest bodyRequest = sendPost(pattern);
        logger.debug("ID: {}", bodyRequest.getId());
        // Adiciona o ID no final da url de GET
        String getUrl = "https://2.intelx.io/intelligent/search/result?id=";
        String url = getUrl + bodyRequest.getId();

        HttpEntity<String> entity = new HttpEntity<>("parameters", prepareRequestHeaders.getReadyHeaders());
        logger.info("Fazendo requisicao GET na API da INTX endpoint /result com ID: {}", bodyRequest.getId());
        return restTemplate.exchange(url, HttpMethod.GET, entity, GenericRequestClass.class).getBody();
    }

    private ResponseBodyRequest sendPost(String pattern) {
        RequestBody requestBody = new RequestBody(pattern);

        HttpEntity<RequestBody> entity = new HttpEntity<>(requestBody, prepareRequestHeaders.getReadyHeaders());
        String postUrl = "https://2.intelx.io/intelligent/search";
        logger.info("Fazendo requisicao POST na API da INTX com o padrao: {}", pattern);
        return restTemplate.exchange(postUrl, HttpMethod.POST, entity, ResponseBodyRequest.class).getBody();
    }
}
