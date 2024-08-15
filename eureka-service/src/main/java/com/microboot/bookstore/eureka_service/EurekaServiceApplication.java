package com.microboot.bookstore.eureka_service;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

	public static void main(String[] args) {
		MDC.put("serviceName", "EURKA-SERVICE");
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

}
