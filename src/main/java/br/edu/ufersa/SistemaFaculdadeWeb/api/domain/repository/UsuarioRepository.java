package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;


import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Usuario;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findByNome(String nome);
}
