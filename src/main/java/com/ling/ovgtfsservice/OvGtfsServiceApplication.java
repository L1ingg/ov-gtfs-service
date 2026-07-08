package com.ling.ovgtfsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OvGtfsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OvGtfsServiceApplication.class, args);
	}

}
