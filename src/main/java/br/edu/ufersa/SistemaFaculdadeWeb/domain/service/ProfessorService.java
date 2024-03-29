package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Professor;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Usuario;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.ProfessorRepository;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.UsuarioRepository;

@Service
public class ProfessorService implements ServiceInterface<Professor>{
	@Autowired
	ProfessorRepository rep;
	@Autowired
	UsuarioRepository repositoryUser;
	
	public List<Professor> getAll() {
		List<Professor> profs = rep.findAll();
		return profs;
	}	
	
	public Professor getAt(UUID id) {
		Professor prof = rep.findByUuid(id);
		return prof;
	}
	
	public Professor getByCpf(String cpf) {
		Professor prof = rep.findByCpf(cpf);
		return prof;
	}
	
	public Professor getByNome(String nome) {
		Professor prof = rep.findByNome(nome);
		return prof;
	}

	public Professor create(Professor obj) {
		String senhaEncriptada = BCrypt.hashpw(obj.getSenha(), BCrypt.gensalt(8));
		obj.setSenha(senhaEncriptada);
		
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(1);
		Usuario dados = repositoryUser.save(user);
		
		obj.setId(dados.getId());
		obj.setUuid(UUID.randomUUID());
		rep.save(obj);
		
		return obj;
	}
	
	public boolean delete(UUID id) {
		Professor prof = rep.findByUuid(id);
		if(prof != null){
			Usuario user = repositoryUser.findById(prof.getId());
			rep.delete(prof);
			repositoryUser.delete(user);
			return true;
		}
		return false;
	}

	public Professor update(Professor obj) {
		String senhaEncriptada = BCrypt.hashpw(obj.getSenha(), BCrypt.gensalt(8));
		obj.setSenha(senhaEncriptada);
		
		Professor dados = rep.findByUuid(obj.getUuid());
		obj.setId(dados.getId());
		obj.setCpf(dados.getCpf());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(1);
		repositoryUser.save(user);
		
		return rep.save(obj);
	}

	public Professor updatePatch(Professor obj) {
		Professor dados = rep.findByCpf(obj.getCpf());
		obj.setId(dados.getId());
		obj.setUuid(dados.getUuid());
		obj.setCpf(dados.getCpf());
		
		Usuario user = repositoryUser.findById(obj.getId());
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(1);
		repositoryUser.save(user);
		
		return rep.save(obj);
	}

}
