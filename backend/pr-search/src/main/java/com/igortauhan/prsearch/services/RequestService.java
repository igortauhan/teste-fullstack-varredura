package com.igortauhan.prsearch.services;

import com.igortauhan.prsearch.models.GenericRequestClass;
import com.igortauhan.prsearch.models.intx.RequestBody;
import com.igortauhan.prsearch.models.intx.ResponseBodyRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RequestService {

    private final RestTemplate restTemplate;

    private final String apiKey = System.getenv("INTX_API_KEY");
    private final String postUrl = "https://2.intelx.io/intelligent/search";
    private final String getUrl = "https://2.intelx.io/intelligent/search/result?id=";

    public RequestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public GenericRequestClass search(String pattern) {
        ResponseBodyRequest bodyRequest = sendPost(pattern);

        String url = getUrl + bodyRequest.getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(
                "user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"
        );
        headers.add(
                "x-key",
                apiKey
        );
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, GenericRequestClass.class).getBody();
    }

    private ResponseBodyRequest sendPost(String pattern) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(
                "user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"
        );
        headers.add(
                "x-key",
                apiKey
        );

        RequestBody requestBody = new RequestBody(pattern);

        HttpEntity<RequestBody> entity = new HttpEntity<>(requestBody, headers);
        return restTemplate.exchange(postUrl, HttpMethod.POST, entity, ResponseBodyRequest.class).getBody();
    }
}
