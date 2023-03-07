package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Professor;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.ProfessorRepository;

@Service
public class ProfessorService implements ServiceInterface<Professor>{
	@Autowired
	ProfessorRepository rep;
	
	public List<Professor> getAll() {
		List<Professor> profs = rep.findAll();
		return profs;
	}	
	
	public Professor getAt(UUID id) {
		Professor prof = rep.findByUuid(id);
		return prof;
	}

	public Professor create(Professor obj) {
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
