package com.igortauhan.prgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PrGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrGatewayApplication.class, args);
	}

}
