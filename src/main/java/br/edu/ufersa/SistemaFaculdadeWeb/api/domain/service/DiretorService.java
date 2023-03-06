package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Diretor;
import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.repository.DiretorRepository;

@Service
public class DiretorService implements ServiceInterface<Diretor>{
	@Autowired
	DiretorRepository repository;

	@Override
	public List<Diretor> getAll() {
		List<Diretor> Diretors = repository.findAll();
		return Diretors;
	}

	@Override
	public Diretor getAt(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diretor create(Diretor obj) {
		obj.setUuid(UUID.randomUUID());
		repository.save(obj);
		return obj;
	}

	@Override
	public Diretor update(Diretor obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Diretor updatePatch(Diretor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UUID id) {
		return false;
	}
}
