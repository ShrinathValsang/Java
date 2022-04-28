package com.futurex.services.FuturexEurekaDiscoveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FuturexEurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturexEurekaDiscoveryServerApplication.class, args);
	}

}
