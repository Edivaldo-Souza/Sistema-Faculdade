package br.edu.ufersa.SistemaFaculdadeWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class SistemaFaculdadeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaFaculdadeWebApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
