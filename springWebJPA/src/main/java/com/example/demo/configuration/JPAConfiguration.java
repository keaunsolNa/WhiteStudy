package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.example.demo"})
@EnableJpaRepositories(basePackages = "com.example.demo")
public class JPAConfiguration {
	
}