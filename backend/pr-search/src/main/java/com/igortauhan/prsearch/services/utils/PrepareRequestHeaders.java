package com.igortauhan.prsearch.services.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class PrepareRequestHeaders {

    private String apiKey;

    @Autowired
    public PrepareRequestHeaders(@Value("${key.intx}") String apikey) {
        this.apiKey = apikey;
    }

    @Bean
    public HttpHeaders getReadyHeaders() {
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
        return headers;
    }
}
