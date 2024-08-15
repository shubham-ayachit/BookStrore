package com.microboot.bookstore.bookcatalog;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookCatalogApplication {

	public static void main(String[] args) {
		MDC.put("serviceName", "BOOK-CATALOG");
		SpringApplication.run(BookCatalogApplication.class, args);
	}
}
