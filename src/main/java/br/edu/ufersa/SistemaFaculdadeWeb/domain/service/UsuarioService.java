package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario getByNome(String nome) {
		return repository.findByNome(nome);
	}
	
}
