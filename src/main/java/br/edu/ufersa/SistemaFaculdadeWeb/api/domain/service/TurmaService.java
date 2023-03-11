package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Turma;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.TurmaRepository;

@Service
public class TurmaService implements ServiceInterface<Turma>{
	@Autowired
	TurmaRepository repository;

	@Override
	public List<Turma> getAll() {
		List<Turma> Turmas = repository.findAll();
		return Turmas;
	}

	@Override
	public Turma getAt(UUID id) {
		Turma turma = repository.findByUuid(id);
		return turma;
	}

	@Override
	public Turma create(Turma obj) {
		obj.setUuid(UUID.randomUUID());
		obj.setStatus(true);
		repository.save(obj);
		return obj;
	}

	@Override
	public Turma update(Turma obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Turma updatePatch(Turma obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UUID id) {
		Turma turma = repository.findByUuid(id);
		if(turma!=null) {repository.delete(turma); return true;}
		else return false;
	}
}
