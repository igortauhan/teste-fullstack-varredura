package com.igortauhan.prsearch.services.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

public class PrepareRequestHeaders {

    private static final String apiKey = System.getenv("INTX_API_KEY");

    public static HttpHeaders getReadyHeaders() {
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
