package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
	Diretor findByUuid(UUID id);
	Diretor findByNome(String nome);
}
