package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	Disciplina findByUuid(UUID uuid);
	Disciplina findByCodigo(String cod);
}
