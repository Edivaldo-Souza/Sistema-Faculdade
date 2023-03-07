package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Disciplina;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService implements ServiceInterface<Disciplina>{
	@Autowired
	DisciplinaRepository rep;
	
	@Override
	public List<Disciplina> getAll() {
		List<Disciplina> disciplinas = rep.findAll();
		return disciplinas;
	}

	@Override
	public Disciplina getAt(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disciplina create(Disciplina obj) {
		obj.setUuid(UUID.randomUUID());
		rep.save(obj);
		return obj;
	}
	
	@Override
	public boolean delete(UUID id) {
		return false;
	}

	@Override
	public Disciplina update(Disciplina obj) {
		rep.save(obj);
		return obj;
	}

	@Override
	public Disciplina updatePatch(Disciplina obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
