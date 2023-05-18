package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	
	public Aluno getByNome(String n) {
		return repository.findByNome(n);
	}

	@Override
	public Aluno create(Aluno obj) {
		String senhaEncriptada = BCrypt.hashpw(obj.getSenha(), BCrypt.gensalt(8));
		obj.setSenha(senhaEncriptada);
		
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(0);
		Usuario dados = repositoryUser.save(user);
	 
		obj.setId(dados.getId());
		obj.setUuid(UUID.randomUUID());
		repository.save(obj);
		
		return obj;
	}
	
	public Aluno create(Aluno obj,String diretorCod) {
		String senhaEncriptada = BCrypt.hashpw(obj.getSenha(), BCrypt.gensalt(8));
		obj.setSenha(senhaEncriptada);
		
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setUuid(UUID.randomUUID());
		if(diretorCod.compareTo("b588kd")==0 || diretorCod.compareTo("gh239ld")==0) {
			user.setPermissao(2);
			repositoryUser.save(user);
			
		}
		else {
			user.setPermissao(0);
			Usuario dados = repositoryUser.save(user);
			
			obj.setId(dados.getId());
			obj.setUuid(UUID.randomUUID());
			repository.save(obj);
		}
		
		
		return obj;
	}

	@Override
	public Aluno update(Aluno obj) {
		String senhaEncriptada = BCrypt.hashpw(obj.getSenha(), BCrypt.gensalt(8));
		obj.setSenha(senhaEncriptada);
		
		Aluno dados = repository.findByUuid(obj.getUuid());
		obj.setId(dados.getId());
		obj.setMatricula(dados.getMatricula());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(0);
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
		user.setPermissao(0);
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
