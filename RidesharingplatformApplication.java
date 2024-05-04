package com.cognizant.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.cognizant.*")
@EnableJpaRepositories(basePackages = "com.cognizant.main.repository")
@EntityScan(basePackages = "com.cognizant.main.entities")
@ComponentScan(basePackages = "com.cognizant.*")
@EnableDiscoveryClient(autoRegister=true)
public class RidesharingplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(RidesharingplatformApplication.class, args);
	}

}
