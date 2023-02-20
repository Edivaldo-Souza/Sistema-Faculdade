package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{

}
