package com.klef.soa.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaundryPickupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaundryPickupApplication.class, args);
		System.out.println("LaundryPickup is up...!");
	}

}
