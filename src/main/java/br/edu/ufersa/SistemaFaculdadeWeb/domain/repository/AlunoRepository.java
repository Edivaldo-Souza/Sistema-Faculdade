package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{

	Aluno findByUuid(UUID uuid);
	Aluno findByNome(String nome);
}
