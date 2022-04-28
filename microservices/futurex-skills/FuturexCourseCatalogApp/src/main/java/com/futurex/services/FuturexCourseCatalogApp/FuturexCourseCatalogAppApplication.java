package com.futurex.services.FuturexCourseCatalogApp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@CircuitBreaker(name = "getCourseAppHome")
public class FuturexCourseCatalogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturexCourseCatalogAppApplication.class, args);
	}

}
