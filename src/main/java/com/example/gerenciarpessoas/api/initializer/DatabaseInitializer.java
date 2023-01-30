package com.example.gerenciarpessoas.api.initializer;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gerenciarpessoas.api.model.Endereco;
import com.example.gerenciarpessoas.api.model.Pessoa;
import com.example.gerenciarpessoas.api.repository.EnderecoRepository;
import com.example.gerenciarpessoas.api.repository.PessoaRepository;

@Component
public class DatabaseInitializer {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostConstruct
	public void init() {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Rafael Moraes");
		pessoa1.setDataNascimento(new Date());
		pessoaRepository.save(pessoa1);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Maria Liliana");
		pessoa2.setDataNascimento(new Date());
		pessoaRepository.save(pessoa2);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Catarina Lemos");
		pessoa3.setDataNascimento(new Date());
		pessoaRepository.save(pessoa3);

		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua A");
		endereco1.setCep("123456");
		endereco1.setNumero("10");
		endereco1.setCidade("São Paulo");
		endereco1.setPrincipal(false);
		endereco1.setPessoa(pessoa1);
		enderecoRepository.save(endereco1);

		Endereco endereco2 = new Endereco();
		endereco2.setLogradouro("Rua B");
		endereco2.setCep("234567");
		endereco2.setNumero("20");
		endereco2.setCidade("Fortaleza");
		endereco2.setPrincipal(true);
		endereco2.setPessoa(pessoa1);
		enderecoRepository.save(endereco2);
		
		Endereco endereco3 = new Endereco();
		endereco3.setLogradouro("Rua C");
		endereco3.setCep("123345");
		endereco3.setNumero("20");
		endereco3.setCidade("Curitiba");
		endereco3.setPrincipal(false);
		endereco3.setPessoa(pessoa2);
		enderecoRepository.save(endereco3);
		
		Endereco endereco4 = new Endereco();
		endereco4.setLogradouro("Rua D");
		endereco4.setCep("098567");
		endereco4.setNumero("20");
		endereco4.setCidade("Cascavel");
		endereco4.setPrincipal(true);
		endereco4.setPessoa(pessoa2);
		enderecoRepository.save(endereco4);
		
		Endereco endereco5 = new Endereco();
		endereco5.setLogradouro("Rua F");
		endereco5.setCep("345678");
		endereco5.setNumero("20");
		endereco5.setCidade("Ouro Preto");
		endereco5.setPrincipal(false);
		endereco5.setPessoa(pessoa1);
		enderecoRepository.save(endereco5);
		
		Endereco endereco6 = new Endereco();
		endereco6.setLogradouro("Rua G");
		endereco6.setCep("0890345");
		endereco6.setNumero("20");
		endereco6.setCidade("Belo Horizonte");
		endereco6.setPrincipal(true);
		endereco6.setPessoa(pessoa3);
		enderecoRepository.save(endereco6);
	}
}
