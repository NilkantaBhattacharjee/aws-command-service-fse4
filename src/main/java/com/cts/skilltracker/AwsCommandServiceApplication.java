package com.cts.skilltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { ContextStackAutoConfiguration.class })
@ComponentScan(basePackages = "com.cts.*")
@EnableCaching
public class AwsCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsCommandServiceApplication.class, args);
	}

}
