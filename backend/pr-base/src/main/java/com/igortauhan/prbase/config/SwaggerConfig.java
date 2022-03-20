package com.igortauhan.prbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.igortauhan.prbase"))
                .paths(regex("/ativos.*"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Teste FullStack Varredura API Rest",
                "API que contem os Endpoints do CRUD de Ativos e as classes de Dominio da aplicacao",
                "1.0",
                "",
                new Contact("Igor Tauhan", "https://github.com/igortauhan", "igortauh.contato@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
