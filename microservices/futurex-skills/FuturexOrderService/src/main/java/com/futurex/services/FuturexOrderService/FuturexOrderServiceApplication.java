package com.futurex.services.FuturexOrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FuturexOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturexOrderServiceApplication.class, args);
	}

}
