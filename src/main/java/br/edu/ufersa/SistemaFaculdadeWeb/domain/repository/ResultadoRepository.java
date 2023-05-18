package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.ResultadoAluno;

public interface ResultadoRepository extends JpaRepository<ResultadoAluno,Long>{
	List<ResultadoAluno> findByMatricula(String mat);
	List<ResultadoAluno> findByTurma(UUID turma);
	ResultadoAluno findByUuid(UUID id);
}
