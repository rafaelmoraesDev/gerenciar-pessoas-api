package com.example.gerenciarpessoas.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gerenciarpessoas.api.model.Endereco;
import com.example.gerenciarpessoas.api.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public List<Endereco> listar() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		return enderecos;
	}

	@PostMapping
	public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco, HttpServletResponse response) {

		Endereco enderecoSalvo = enderecoRepository.save(endereco);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(enderecoSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(enderecoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Endereco> buscarPeloCodigo(@PathVariable Long codigo) {
		Endereco endereco = enderecoRepository.findById(codigo).orElse(null);
		return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		enderecoRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long codigo, @Valid @RequestBody Endereco endereco) {
		Endereco enderecoSalvo = enderecoRepository.findById(codigo).orElse(null);
		BeanUtils.copyProperties(endereco, enderecoSalvo, "codigo");
		enderecoRepository.save(enderecoSalvo);
		return ResponseEntity.ok(enderecoSalvo);
	}
}
