package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Autorizacao;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Diretor;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Usuario;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.DiretorRepository;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.UsuarioRepository;

@Service
public class DiretorService implements ServiceInterface<Diretor>{
	@Autowired
	DiretorRepository repository;
	@Autowired
	UsuarioRepository repositoryUser;

	@Override
	public List<Diretor> getAll() {
		List<Diretor> Diretors = repository.findAll();
		return Diretors;
	}

	@Override
	public Diretor getAt(UUID id) {
		return repository.findByUuid(id);
	}

	@Override
	public Diretor create(Diretor obj) {
		
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		Usuario dados = repositoryUser.save(user);
		
		obj.setId(dados.getId());
		obj.setUuid(UUID.randomUUID());
		repository.save(obj);
		
		return obj;
	}

	@Override
	public Diretor update(Diretor obj) {
		
		Diretor dir = repository.findByUuid(obj.getUuid());
		obj.setId(dir.getId());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		repositoryUser.save(user);
		
		return repository.save(obj);
	}

	@Override
	public Diretor updatePatch(Diretor obj) {
		
		Diretor dados = repository.findByUuid(obj.getUuid());
		obj.setId(dados.getId());
		obj.setUuid(dados.getUuid());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		repositoryUser.save(user);
		
		return repository.save(obj);
	}

	@Override
	public boolean delete(UUID id) {
		Diretor dir = repository.findByUuid(id);
		if(dir!=null) {
			Usuario user = repositoryUser.findById(dir.getId());
			repository.delete(dir);
			repositoryUser.delete(user);
			return true;
		}
		return false;
	}
}
