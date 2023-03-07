package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Professor;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.ProfessorRepository;

@Service
public class ProfessorService implements ServiceInterface<Professor>{
	ProfessorRepository rep;
	@Override
	public List<Professor> getAll() {
		List<Professor> profs = rep.findAll();
		return profs;
	}	
	@Override
	public Professor getAt(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor create(Professor obj) {
		obj.setUuid(UUID.randomUUID());
		rep.save(obj);
		return obj;
	}
	@Override
	public boolean delete(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Professor update(Professor obj) {
		rep.save(obj);
		return obj;
	}

	@Override
	public Professor updatePatch(Professor obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
