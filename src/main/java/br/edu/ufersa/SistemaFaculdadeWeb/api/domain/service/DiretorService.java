package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Autorizacao;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Diretor;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Usuario;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.DiretorRepository;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.UsuarioRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diretor create(Diretor obj) {
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		repositoryUser.save(user);
		obj.setUuid(UUID.randomUUID());
		repository.save(obj);
		return obj;
	}

	@Override
	public Diretor update(Diretor obj) {
		Diretor dir = repository.findByUuid(obj.getUuid());
		obj.setId(dir.getId());
		repository.save(obj);
		return obj;
	}

	@Override
	public Diretor updatePatch(Diretor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UUID id) {
		Diretor dir = repository.findByUuid(id);
		if(dir!=null) {
			repository.delete(dir);
			return true;
		}
		return false;
	}
}
