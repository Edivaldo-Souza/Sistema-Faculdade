package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
