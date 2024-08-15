package com.microboot.bookstore.cloud_config_service;

import org.jboss.logging.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServiceApplication {

	public static void main(String[] args) {
		MDC.put("serviceName", "CLOUD-CONFIG-SERVICE");
		SpringApplication.run(CloudConfigServiceApplication.class, args);
	}

}
