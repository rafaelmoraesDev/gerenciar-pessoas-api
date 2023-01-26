package com.example.gerenciarpessoas.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.gerenciarpessoas.api.repository.PessoaRepository;

@SpringBootApplication
public class GerenciarPessoasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarPessoasApiApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(PessoaRepository pessoaRepository) {
		return args -> {
			
		};
	}
}
