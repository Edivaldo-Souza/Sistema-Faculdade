package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.ResultadoAluno;

public interface ResultadoRepository extends JpaRepository<ResultadoAluno,Long>{
	ResultadoAluno findByMatricula(long id);
	ResultadoAluno findByUuid(UUID id);
}
