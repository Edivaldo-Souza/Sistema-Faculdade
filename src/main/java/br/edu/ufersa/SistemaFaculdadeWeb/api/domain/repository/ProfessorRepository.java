package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	Professor findByUuid(UUID uuid);
	Professor findByCpf(String cpf);
}
