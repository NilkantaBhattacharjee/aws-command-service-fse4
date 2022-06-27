package com.cts.skilltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AwsCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsCommandServiceApplication.class, args);
	}

}
