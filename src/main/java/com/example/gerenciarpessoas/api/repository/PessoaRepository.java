package com.example.gerenciarpessoas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciarpessoas.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
