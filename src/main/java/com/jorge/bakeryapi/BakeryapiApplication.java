package com.jorge.bakeryapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BakeryapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BakeryapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
