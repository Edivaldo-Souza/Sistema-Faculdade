package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

}
