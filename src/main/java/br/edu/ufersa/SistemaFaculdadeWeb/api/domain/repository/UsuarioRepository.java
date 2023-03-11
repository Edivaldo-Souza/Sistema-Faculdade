package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository;


import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findById(long id); 
	Usuario findByNome(String nome);
}
