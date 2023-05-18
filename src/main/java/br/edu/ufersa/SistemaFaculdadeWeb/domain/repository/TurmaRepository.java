package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	Turma findByUuid(UUID id);
	List<Turma> findByDiscCod(String discCod);
	List<Turma> findByProfCpf(String profCpf);
}
