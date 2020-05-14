package com.nixondinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nixondinho.model.Medico;

@SpringBootApplication
public class SpringBootControlTransitoApplication {
//
	public static void main(String[] args) {
		SpringApplication.run(SpringBootControlTransitoApplication.class, args);

	}
	
	@Bean
	public Medico getMedico() {
		
		return new Medico();
	}

}
