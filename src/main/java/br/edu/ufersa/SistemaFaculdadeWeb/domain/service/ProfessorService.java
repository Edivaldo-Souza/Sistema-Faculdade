package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Autorizacao;
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

	public Professor create(Professor obj) {
		Usuario user = new Usuario();
		user.setNome(obj.getNome());
		user.setSenha(obj.getSenha());
		user.setPermissao(Autorizacao.PROF);
		repositoryUser.save(user);
		obj.setUuid(UUID.randomUUID());
		rep.save(obj);
		return obj;
	}
	
	public boolean delete(UUID id) {
		Professor prof = rep.findByUuid(id);
		if(prof != null){
			rep.delete(prof);
			return true;
		}
		return false;
	}

	public Professor update(Professor obj) {
		Professor prof = rep.findByUuid(obj.getUuid());
		obj.setId(prof.getId());
		rep.save(obj);
		return obj;
	}

	public Professor updatePatch(Professor obj) {
		Professor prof = rep.findByCpf(obj.getCpf());
		obj.setId(prof.getId());
		obj.setUuid(prof.getUuid());		
		return rep.save(obj);
	}

}
