package com.igortauhan.prbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PrBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrBaseApplication.class, args);
	}

}
