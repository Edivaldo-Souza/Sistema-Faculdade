package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Aluno;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Autorizacao;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Usuario;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.AlunoRepository;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.UsuarioRepository;

@Service
public class AlunoService implements ServiceInterface<Aluno>{
	@Autowired
	AlunoRepository repository;
	@Autowired
	UsuarioRepository repositoryUser;

	@Override
	public List<Aluno> getAll() {
		List<Aluno> alunos = repository.findAll();
		return alunos;
	}

	@Override
	public Aluno getAt(UUID id) {
		Aluno aluno = repository.findByUuid(id);
		return aluno;
	}

	@Override
	public Aluno create(Aluno obj) {
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
	public Aluno update(Aluno obj) {
		Aluno dados = repository.findByUuid(obj.getUuid());
		obj.setId(dados.getId());
		return repository.save(obj);
	}

	@Override
	public Aluno updatePatch(Aluno obj) {
		Aluno dados = repository.findByNome(obj.getNome());
		obj.setId(dados.getId());
		obj.setUuid(dados.getUuid());
		return repository.save(obj);
	}

	@Override
	public boolean delete(UUID id) {
		Aluno aluno = repository.findByUuid(id);
		if(aluno==null) return false;
		repository.delete(aluno);
		return true;
	}
}
