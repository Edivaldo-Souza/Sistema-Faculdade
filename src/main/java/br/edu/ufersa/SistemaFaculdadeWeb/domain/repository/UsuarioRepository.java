package br.edu.ufersa.SistemaFaculdadeWeb.domain.repository;


import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Usuario;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findById(long id); 
	Usuario findByNome(String nome);
}
