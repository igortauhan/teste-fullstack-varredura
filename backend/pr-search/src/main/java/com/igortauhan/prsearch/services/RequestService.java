package com.igortauhan.prsearch.services;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.models.intx.RequestBody;
import com.igortauhan.prsearch.models.intx.ResponseBodyRequest;
import com.igortauhan.prsearch.services.utils.PrepareRequestHeaders;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers = PrepareRequestHeaders.getReadyHeaders();

    public RequestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public GenericRequestClass search(String pattern) {
        // Pega o resultado do request na url de POST
        ResponseBodyRequest bodyRequest = sendPost(pattern);
        // Adiciona o ID no final da url de GET
        String getUrl = "https://2.intelx.io/intelligent/search/result?id=";
        String url = getUrl + bodyRequest.getId();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, GenericRequestClass.class).getBody();
    }

    private ResponseBodyRequest sendPost(String pattern) {
        RequestBody requestBody = new RequestBody(pattern);

        HttpEntity<RequestBody> entity = new HttpEntity<>(requestBody, headers);
        String postUrl = "https://2.intelx.io/intelligent/search";
        return restTemplate.exchange(postUrl, HttpMethod.POST, entity, ResponseBodyRequest.class).getBody();
    }
}
