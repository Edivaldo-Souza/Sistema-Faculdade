package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Aluno;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Autorizacao;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Usuario;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.AlunoRepository;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.UsuarioRepository;

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
		return repository.findByUuid(id);
	}

	@Override
	public Aluno create(Aluno obj) {
		obj.setUuid(UUID.randomUUID());
		repository.save(obj);
		Aluno dados = repository.findByNome(obj.getNome());
		
		Usuario user = new Usuario();
		user.setId(dados.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		repositoryUser.save(user);
		
		return obj;
	}

	@Override
	public Aluno update(Aluno obj) {
		
		Aluno dados = repository.findByUuid(obj.getUuid());
		obj.setId(dados.getId());
		obj.setMatricula(dados.getMatricula());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		repositoryUser.save(user);
		
		return repository.save(obj);
	}

	@Override
	public Aluno updatePatch(Aluno obj) {
		Aluno dados = repository.findByNome(obj.getNome());
		obj.setId(dados.getId());
		obj.setUuid(dados.getUuid());
		obj.setMatricula(dados.getMatricula());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(obj.getPermissao());
		repositoryUser.save(user);
		
		return repository.save(obj);
	}

	@Override
	public boolean delete(UUID id) {
		Aluno aluno = repository.findByUuid(id);
		
		if(aluno==null) return false;
		
		Usuario user = repositoryUser.findById(aluno.getId());
		repository.delete(aluno);
		repositoryUser.delete(user);
		return true;
	}
}
