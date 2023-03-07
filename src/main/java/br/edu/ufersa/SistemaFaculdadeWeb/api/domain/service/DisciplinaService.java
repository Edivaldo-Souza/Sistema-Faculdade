package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Disciplina;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService implements ServiceInterface<Disciplina>{
	
	DisciplinaRepository rep;
	
	@Override
	public List<Disciplina> getAll() {
		List<Disciplina> disciplinas = rep.findAll();
		return disciplinas;
	}

	@Override
	public Disciplina getAt(UUID id) {
		Disciplina disc = rep.findByUuid(id);
		return disc;
	}

	@Override
	public Disciplina create(Disciplina obj) {
		obj.setUuid(UUID.randomUUID());
		rep.save(obj);
		return obj;
	}
	
	@Override
	public boolean delete(UUID id) {
		Disciplina disc = rep.findByUuid(id);
		if(disc != null) {
			rep.delete(disc);
			return true;
		}
		return false;
	}

	@Override
	public Disciplina update(Disciplina obj) {
		rep.save(obj);
		return obj;
	}

	@Override
	public Disciplina updatePatch(Disciplina obj) {
		Disciplina disc = rep.findByCodigo(obj.getCodigo());
		obj.setId(disc.getId());
		obj.setUuid(disc.getUuid());
		return rep.save(obj);
	}

}
