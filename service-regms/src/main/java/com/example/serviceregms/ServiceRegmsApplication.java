package com.example.serviceregms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegmsApplication.class, args);
	}

}
