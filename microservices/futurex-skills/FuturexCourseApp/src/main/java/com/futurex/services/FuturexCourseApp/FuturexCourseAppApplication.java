package com.futurex.services.FuturexCourseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FuturexCourseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturexCourseAppApplication.class, args);
	}

}
