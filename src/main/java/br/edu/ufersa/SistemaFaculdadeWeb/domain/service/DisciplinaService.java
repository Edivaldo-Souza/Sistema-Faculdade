package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Disciplina;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.DisciplinaRepository;

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
		Disciplina disc = rep.findByUuid(id);
		return disc;
	}
	
	public Disciplina getByCodigo(String cod) {
		Disciplina disc = rep.findByCodigo(cod);
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
		Disciplina disc = rep.findByUuid(obj.getUuid());
		obj.setId(disc.getId());
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
