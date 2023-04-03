package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImtApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapmeth() {
		return new ModelMapper();
	}
}
