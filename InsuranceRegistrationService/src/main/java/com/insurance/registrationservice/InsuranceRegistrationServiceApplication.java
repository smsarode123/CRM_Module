package com.insurance.registrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class InsuranceRegistrationServiceApplication {

	public static void main(String[] args) {
		System.out.println("This is registartion service module");
		SpringApplication.run(InsuranceRegistrationServiceApplication.class, args);
	}

}
