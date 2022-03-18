package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.services.AtivoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ativos")
public class AtivoController {

    private AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping()
    public String helloWorld() {
        return "Hello, world!";
    }
}
