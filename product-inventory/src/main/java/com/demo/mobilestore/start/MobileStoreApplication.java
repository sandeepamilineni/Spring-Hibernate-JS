package com.demo.mobilestore.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.demo.mobilestore.controller")
@EntityScan("com.demo.mobilestore.model")
@EnableJpaRepositories("com.demo.mobilestore.dao")
public class MobileStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileStoreApplication.class, args);
	}

}
