package com.futurex.services.FuturexUserApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FuturexUserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturexUserAppApplication.class, args);
	}

}
