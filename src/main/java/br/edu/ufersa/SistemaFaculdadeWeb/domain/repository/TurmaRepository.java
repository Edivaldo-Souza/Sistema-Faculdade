package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	Turma findByUuid(UUID id);
}
